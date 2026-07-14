class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;

        int cnt = 0, i = 0, j = 0;
        while(j < n){
            if(nums[j] != val){
                cnt++;
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return cnt;
    }
}