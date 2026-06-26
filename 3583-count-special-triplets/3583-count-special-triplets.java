class Solution {
    static final int MOD = (int)(1e9 + 7);
    public int specialTriplets(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> totalFreq = new HashMap<>();
        Map<Integer, Integer> leftFreq = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            totalFreq.put(nums[i], totalFreq.getOrDefault(nums[i], 0) + 1);
        }

        long ans = 0;
        for(int i = 0 ; i < n ; i++){
            int target = nums[i] * 2;
//abhi to hm is number pr khde hi h, to hme to sse peeche tk ki freq chahiye na
            int leftCnt = leftFreq.getOrDefault(target, 0);
            leftFreq.put(nums[i], leftFreq.getOrDefault(nums[i], 0) + 1); //isse is number ki left freq mil jayegi agli baar ke liye
            //aur right freq ke liye total - left krdo bs

            int rightCnt = totalFreq.getOrDefault(target, 0) - leftFreq.getOrDefault(target, 0);

            ans = (ans + (long)leftCnt * rightCnt) % MOD;
        }
        return (int)ans;
    }
}