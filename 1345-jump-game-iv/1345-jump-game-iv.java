class Solution {
    public int minJumps(int[] arr) {

        int n = arr.length, cnt = 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }

        HashSet<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(0);
        visited[0] = true;

        while(!queue.isEmpty()){

            int size = queue.size();

            while(size-- > 0){

                int i = queue.poll();

                if(i == n - 1) return cnt;

                //i - 1
                if(i - 1 >= 0 && !visited[i - 1]){
                    queue.offer(i - 1);
                    visited[i - 1] = true;
                }

                //i + 1
                if(i + 1 < n && !visited[i + 1]){
                    queue.offer(i + 1);
                    visited[i + 1] = true;
                }

                //a[i] = a[j] , i != j
                if(map.containsKey(arr[i]) && !set.contains(arr[i])){
                    for(int j : map.get(arr[i])){
                        if(!visited[j]){
                            visited[j] = true;
                            queue.offer(j);
                        }
                    }
                    set.add(arr[i]);
                }
            }
            cnt++;
        }
        return cnt;
    }
}