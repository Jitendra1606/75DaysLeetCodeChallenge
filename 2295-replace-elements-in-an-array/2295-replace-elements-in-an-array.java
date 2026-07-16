class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        int n = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            map.put(nums[i], i);
        }

        for(int i = 0 ; i < operations.length ; i++){
            int a = operations[i][0];
            int b = operations[i][1];

            int ind = map.get(a);

            nums[ind] = b;

            map.remove(a);
            map.put(b, ind); 
        }
        return nums;
    }
}