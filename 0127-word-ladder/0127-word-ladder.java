class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        q.offer(new Pair(beginWord, 1)); //put given word with level 1 in the queue

        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i)); //adding all the words in the set for fast access 
        } // ans comparison

        set.remove(beginWord); //bcz we don't want to start again with this word in future

        while (!q.isEmpty()) {

            String word = q.peek().first; //current word
            int cnt = q.peek().second; //current word's level

            q.poll(); //also remove from the queue

            if (word.equals(endWord) == true)
                return cnt; //if we found our answer

            //now generating all possible words of current word from queue
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {

                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch; //replacing chars of the word by first converting it into array

                    String replacedWord = new String(replacedCharArray);//converting back to string

                    //now check if it exists in our set or not
                    if (set.contains(replacedWord)) {
                        set.remove(replacedWord); //now remove this word from set also
                        q.offer(new Pair(replacedWord, cnt + 1)); //add in queue with lvl+
                    }
                }
            }
        }
        return 0; //if no answer exists
    }
}

class Pair {
    String first;
    int second;

    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}