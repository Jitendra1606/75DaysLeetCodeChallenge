class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int absSum = 0;
        if(n < 3) return -1;
        int ans = Integer.MAX_VALUE;
        boolean goodTuple = false;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                if(nums[i] != nums[j]) continue;
                for(int k = j + 1 ; k < n ; k++){
                    if(nums[k] == nums[i]){
                        absSum = Math.abs(i - j) + Math.abs(j - k) + Math.abs(k - i);
                        if(absSum < ans){
                            ans = absSum;
                            goodTuple = true;
                        }
                    }
                }
            }
        }
        if(goodTuple == true) return ans;
        return -1;
    }
}