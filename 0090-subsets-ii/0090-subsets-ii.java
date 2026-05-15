class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void solve(int[] nums, int ind, List<Integer> list, List<List<Integer>> result){
        if(ind == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        result.add(new ArrayList<>(list));
        for(int i = ind ; i < nums.length ; i++){

            if(i > ind && nums[i] == nums[i - 1]){ //same condition as combination sum 3
                continue;
            }

            list.add(nums[i]);

            solve(nums, i + 1, list, result);

            list.remove(list.size() - 1);
        }
    }
}
//t.c = O(n.2^n)
//s.c = O(n.2^n)