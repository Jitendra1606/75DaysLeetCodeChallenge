class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        int n = nums.length;

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        int last = lower - 1;

        for (int i = 0; i < n; i++) {

            //ignore numbers outside our range
            if (lower > nums[i]) {  //nums=[1,1], lo=5, up=7
                continue;
            } 

            if(nums[i] > upper) { //nums=[2,3,5], lo=2, up=3
                break;
            }

            //missing ranges b/w last and current number
            if(nums[i] > last + 1){
                result.add(new ArrayList<>(Arrays.asList(last + 1, nums[i] - 1)));
            }

            last = nums[i]; //since, we're updating last at each index
        }

        //missing numbers after last number in array
        if(last < upper){
            result.add(new ArrayList<>(Arrays.asList(last + 1, upper)));
        }

        return result;
    }
}