class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);   
        //fixing one element n1 
        for(int i = 0 ; i < nums.length ; i++){
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            int n1 = nums[i];
            int target = -n1;
            //twosum will find n2 and n3 : {n1, n2, n3}
            twosum(nums, target, i + 1, result);
        }
        return result;
    }
    public void twosum(int[] nums, int target, int i,List<List<Integer>> result ){
        int j = nums.length - 1;
        while(i < j){
            if(nums[i] + nums[j] > target) j--;
            else if(nums[i] + nums[j] < target) i++;
            else {//first we will remove duplicates from either end(i,j)
            result.add(Arrays.asList(-target, nums[i], nums[j]));
            while(i < j && nums[i] == nums[i + 1]) i++;
            while(i < j && nums[j] == nums[j - 1]) j--;
            
            i++;
            j--;
            }
        }
    }
}