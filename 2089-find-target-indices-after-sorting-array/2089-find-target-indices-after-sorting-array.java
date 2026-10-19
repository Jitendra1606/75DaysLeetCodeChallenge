class Solution{
    public List<Integer> targetIndices(int[] nums, int target){
        int n = nums.length;
        int lessThanCount = 0;
        int targetCount = 0;

        for(int num : nums){
            if(num < target) lessThanCount++;

            else if(num == target) targetCount++;
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < targetCount ; i++){
            list.add(lessThanCount + i);
        }

        return list;
    }
}


// class Solution {
//     public List<Integer> targetIndices(int[] nums, int target) {
//         List<Integer> list = new ArrayList<>();
//         Arrays.sort(nums);

//         for(int i = 0 ; i < nums.length ; i++){
//             if(nums[i] == target) list.add(i);
//             if(nums[i] > target) return list;
//         }

//         return list;
//     }
// }