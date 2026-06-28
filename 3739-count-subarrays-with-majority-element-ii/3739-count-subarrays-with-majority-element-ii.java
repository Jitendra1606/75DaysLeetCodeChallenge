class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        int curSum = 0;

        map.put(0, 1);
        long validLeft = 0;
        long result = 0;

        for(int x : nums){
            if(x == target) {
                validLeft += map.getOrDefault(curSum, 0);
                curSum++;
            }else{
                curSum--;
                validLeft -= map.getOrDefault(curSum, 0);
            }

            map.merge(curSum, 1, Integer::sum);
            result += validLeft;
        }
        return result;
    }
}