class LFUCache {

    class Node {
        int key;
        int value;
        int freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLL {
        Node head;
        Node tail;
        int size;

        DLL() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast() {
            if (size == 0) return null;

            Node node = tail.prev;
            remove(node);
            return node;
        }
    }

    int capacity;
    int size;
    int minFreq;

    HashMap<Integer, Node> keyToNode;
    HashMap<Integer, DLL> freqToList;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        keyToNode = new HashMap<>();
        freqToList = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key))
            return -1;

        Node node = keyToNode.get(key);
        updateFreq(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;

        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }

        if (size == capacity) {
            DLL minList = freqToList.get(minFreq);
            Node toRemove = minList.removeLast();
            keyToNode.remove(toRemove.key);
            size--;
        }

        Node newNode = new Node(key, value);
        keyToNode.put(key, newNode);

        DLL list = freqToList.getOrDefault(1, new DLL());
        list.addFirst(newNode);
        freqToList.put(1, list);

        minFreq = 1;
        size++;
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;

        DLL oldList = freqToList.get(oldFreq);
        oldList.remove(node);

        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        DLL newList = freqToList.getOrDefault(node.freq, new DLL());
        newList.addFirst(node);
        freqToList.put(node.freq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */