class Solution {
    public boolean uniformArray(int[] nums1) {
        int even = 0, odd = 0, min = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums1.length ; i++){
            min = Math.min(min, nums1[i]); 
            if(nums1[i] % 2 == 0) even++;
            else odd++;
        }
        if(even == 0 || odd == 0) return true;
        if(min % 2 == 0) return false;
        return true;
    }
}