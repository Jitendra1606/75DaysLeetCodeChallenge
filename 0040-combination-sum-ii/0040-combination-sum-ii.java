class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void solve(int[] nums, int target, int ind, List<Integer> list, List<List<Integer>> result){
        
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = ind ; i < nums.length ; i++){
            if(i > ind && nums[i] == nums[i - 1]) continue;

            if(nums[i] > target) break;

            list.add(nums[i]);
            solve(nums, target - nums[i], i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}