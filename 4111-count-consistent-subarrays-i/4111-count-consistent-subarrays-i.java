class Solution {
    public int countConsistent(int[] nums) {
        int n = nums.length;
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            int min = Integer.MAX_VALUE;
            int and = nums[i];

            for(int j = i ; j < n ; j++){
                and = and & nums[j];
                min = Math.min(min, nums[j]);

                if(min == and) cnt++;
            }
        }

        return cnt;
    }
}