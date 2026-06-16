class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;

        solve(0, new ArrayList<>(), nums);
        return result;
    }

    public void solve(int ind, List<Integer> list, int[] nums) {
 
            if (list.size() >= 2) {
                result.add(new ArrayList<>(list));
            }

            HashSet<Integer> set = new HashSet<>();

        for(int i = ind ; i < nums.length ; i++){
            if(set.contains(nums[i])) continue;

            if(list.isEmpty() || nums[i] >= list.get(list.size() - 1)){
                set.add(nums[i]);
                list.add(nums[i]);
                solve(i + 1, list, nums);
                list.remove(list.size() - 1);
            }
        }
    }
}