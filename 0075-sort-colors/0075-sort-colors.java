class Solution {
    public void sortColors(int[] nums) {
        int l = 0, m = 0, h = nums.length - 1;
        while(m <= h){
            if(nums[m] == 0){
                swap(nums, l, m);
                l++;
                m++;
            }else if(nums[m] == 1){
                m++;
            }else{
                swap(nums, m, h);
                h--;
            }
        }
    }
    static void swap(int[] nums, int s, int e){
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }
}