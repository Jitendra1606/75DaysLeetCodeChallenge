class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;

        int[] ans = new int[n - k + 1];

        for(int i = 0 ; i <= n - k ; i++){
            boolean ok = true;
            
            for(int j = i ; j < i + k - 1 ; j++){
                if(nums[j + 1] != nums[j] + 1){
                    ok = false;
                    break;
                }
            }

            ans[i] = ok ? nums[i + k - 1] : -1;
        }

        return ans;
    }
}