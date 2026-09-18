class Solution{
    public int minSumOfLengths(int[] arr, int target){
        int n = arr.length;
        int[] best = new int[n];
        Arrays.fill(best, Integer.MAX_VALUE);

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int pre = 0;
        int ans = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++){
            pre += arr[i];

            int req = pre - target;
            if(map.containsKey(req)){
                int prev = map.get(req);
                int sta = prev + 1;
                int len = i - prev;

                if(prev >= 0 && best[prev] != Integer.MAX_VALUE){
                    ans = Math.min(ans, len + best[prev]);
                }
            }
            if(i > 0){
                best[i] = best[i - 1];
            }
            if(map.containsKey(req)){
                int prev = map.get(req);
                int len = i - prev;
                best[i] = Math.min(best[i], len);
            }
            map.put(pre, i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}


// //gpt link - https://chatgpt.com/share/6aab8326-09a8-83ee-961e-4dc2e55df6fe
// class Solution {
//     public int minSumOfLengths(int[] arr, int target) {
//         int n = arr.length;
//         int[] best = new int[n];

//         Arrays.fill(best, Integer.MAX_VALUE);   

//         Map<Integer, Integer> map = new HashMap<>();
//         map.put(0, -1);

//         int pre = 0;

//         int ans = Integer.MAX_VALUE;

//         for(int i = 0 ; i < n ; i++){
//             pre += arr[i]; //prefix sum

//             int req = pre - target;

//             if(map.containsKey(req)){
//                 int prev = map.get(req);

//                 int sta = prev + 1;
//                 int length = i - prev;

//                 //we need a previous sub array that ends before 'start'
//                 if(prev >= 0 && best[prev] != Integer.MAX_VALUE){
//                     ans = Math.min(ans, length + best[prev]);
//                 }
//             }

//             if(i > 0){ //carry forward previous best
//                 best[i] = best[i - 1];
//             }

//             //if current subarray exists, update best[i]
//             if(map.containsKey(req)){
//                 int prev = map.get(req);

//                 int len = i - prev;

//                 best[i] = Math.min(best[i], len);
//             }
//             map.put(pre, i);
//         }

//         return ans == Integer.MAX_VALUE ? -1 : ans;
//     }
// }