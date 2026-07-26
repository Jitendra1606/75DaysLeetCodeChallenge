class Solution {
    public int maximizeGreatness(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        
        int i = 0, j = 0;
        int cnt = 0;

        while(j < n){
            if(nums[i] < nums[j]){
                cnt++;
                i++;
            }
            j++;
        }
        return cnt;
    }
}