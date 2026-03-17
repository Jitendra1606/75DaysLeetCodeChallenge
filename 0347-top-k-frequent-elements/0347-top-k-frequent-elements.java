class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < nums.length ; i++){
           map.put(nums[i] , map.getOrDefault(nums[i] , 0) + 1);
        }
        //max heap of pair of element
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);

        for(Map.Entry<Integer, Integer> e : map.entrySet()){
            int key = e.getKey();
            int value = e.getValue();
            pq.offer(new int[]{key , value});
        }

            for(int i = 0 ; i < k ; i++){
                ans[i] = pq.poll()[0];
            }
        return ans;
    }
}