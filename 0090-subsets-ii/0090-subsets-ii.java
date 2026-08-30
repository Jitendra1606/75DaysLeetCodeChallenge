class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        solve(0, nums, new ArrayList<>(), result);
        return result;
    }

    public void solve(int ind, int[] nums, List<Integer> list, List<List<Integer>> result) {

        result.add(new ArrayList<>(list));

        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1])
                continue; //same condition as combination sum 3 e.g[1,1,1]

            list.add(nums[i]);

            solve(i + 1, nums, list, result);

            list.remove(list.size() - 1);
        }
    }
}
//t.c = O(n.2^n)
//s.c = O(n.2^n)

// Let's take:

// nums = [1, 2, 2]

// After sorting.

// Your code starts with:

// solve(0, nums, [], result);
// Why this line?
// result.add(new ArrayList<>(list));

// At the beginning of solve, list represents a valid subset.

// For example:

// list = []

// [] itself is a subset, so we add it.

// Then the loop chooses 1:

// list = [1]

// Now [1] is also a valid subset, so we need to add it.

// Then:

// list = [1,2]

// also a valid subset.

// Then:

// list = [1,2,2]

// also valid.

// So essentially, every time you reach a new list, you can put it into the answer.

// But why not just add at the base case?

// You might think:

// if(ind == nums.length) {
//     result.add(new ArrayList<>(list));
//     return;
// }

// would be enough.

// But consider:

// nums = [1,2]

// The recursion paths are:

// []
//  ↓
// [1]
//  ↓
// [1,2]

// and

// []
//  ↓
// [2]

// If you only add at the base case, you'll get:

// [1,2]
// [2]

// But you're missing:

// []
// [1]

// Those are also subsets.

// That's why the solution adds the current list before continuing to generate larger subsets.