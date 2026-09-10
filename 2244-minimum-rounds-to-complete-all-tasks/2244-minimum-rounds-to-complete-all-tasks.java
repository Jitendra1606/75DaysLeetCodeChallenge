class Solution {
    public int minimumRounds(int[] tasks) {
        int n = tasks.length;

        Arrays.sort(tasks);
        Map<Integer, Integer> map = new HashMap<>();

        for (int x : tasks)
            map.put(x, map.getOrDefault(x, 0) + 1);

        int ans = 0;
        for (int value : map.values()) {
            if (value == 1)
                return -1;

            ans += (int) (Math.ceil((double)value / 3));
        }

        return ans;
    }
}

// class Solution {
//     public int minimumRounds(int[] tasks) {
//         int n = tasks.length;
//         Arrays.sort(tasks);
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i = 0 ; i < n ; i++){
//             map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
//         }
//         int cnt = 0;
//         for(int value : map.values()){
//             if(value == 1) return -1;
//             cnt += (int)Math.ceil((double)value / 3); 
//         }
//         return cnt;
//     }
// }