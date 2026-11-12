class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int len = 1;

        for(int i = 1 ; i < nums.length ; i++){
            int cntinc = 1;

            for(int j = i ; j < nums.length ; j++){
                if(nums[j - 1] < nums[j]){
                    cntinc++;
                }else{
                    break;
                }
            }
            len = Math.max(len, cntinc);
        }

        for(int i = 1 ; i < nums.length ; i++){
            int cntdec = 01;

            for(int j = i ; j < nums.length ; j++){
                if(nums[j - 1] > nums[j]){
                    cntdec++;
                }else{
                    break;
                }
            }
            len = Math.max(len, cntdec);
        }

        return len;
    }
}