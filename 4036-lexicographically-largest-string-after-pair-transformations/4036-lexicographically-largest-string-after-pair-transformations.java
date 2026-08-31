class Solution {
    public String[] largestString(int[] nums) {
        int n = nums.length; 

        long[] convert = new long[26];
        long base = 1;

        for(int i = 0 ; i < 26 ; i++){
            convert[i] = base;
            base *= 2;
        }

        String[] ans = new String[n];

        for(int j = 0 ; j < n ; j++){
            String cur = "";

            while(nums[j] > 0){

                int i = 25;

                while(convert[i] > nums[j]) i--;

                cur += (char)('a' + i);

                nums[j] -= convert[i];
            }
            ans[j] = cur;
        }

        return ans;
    }
}