class Solution{
    public List<List<Integer>> fourSum(int[] nums, int target){
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0 ; i < n ; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1 ; j < n ; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1, right = n - 1;
                while(left < right){
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]) left++;
                        while(left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                    else if(sum < target) left++;
                    else right--;
                }
            }
        }
        return ans;
    }
}



// class Solution{
//     public List<List<Integer>> fourSum(int[] nums, int target){
//         int n = nums.length;
//         Set<List<Integer>> set = new HashSet<>();

//         for(int i = 0 ; i < n ; i++){
//             for(int j = i + 1 ; j < n ; j++){
//                 HashSet<Integer> seen = new HashSet<>();

//                 for(int k = j + 1 ; k < n ; k++){
//                     long req = (long)target - (nums[i] + nums[j] + nums[k]);
//                     if(seen.contains((int)req)){
//                         List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) req);
//                         Collections.sort(temp);
//                         set.add(temp);
//                     }

//                     seen.add(nums[k]);
//                 }
//             }
//         }
//         return new ArrayList<>(set);
//     }
// }
//t.c = O(n*n*n*log(m))
//s.c = O(2 * no. of quadraplets) + O(n)


// class Solution {
//     public List<List<Integer>> fourSum(int[] nums, int target) {
//         Set<List<Integer>> set = new HashSet<>();
//         int n = nums.length;
//         for(int i = 0 ; i < n ; i++){
//             for(int j = i + 1 ; j < n ; j++){
//                 for(int k = j + 1 ; k < n ; k++){
//                     for(int l = k + 1 ; l < n ; l++){
//                         long sum = nums[i] + nums[j];
//                         sum += nums[k];
//                         sum += nums[l];
//                         if(sum == target){
//                             List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
//                             Collections.sort(temp);
//                             set.add(temp);
//                         }
//                     }
//                 }
//             }
//         }
//         return new ArrayList<>(set);
//     }
// }