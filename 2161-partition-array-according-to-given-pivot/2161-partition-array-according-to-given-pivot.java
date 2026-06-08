class Solution{
    public int[] pivotArray(int[] nums, int pivot){
        int n = nums.length;

        int[] ans = new int[n];
        int ind = 0;

        for(int num : nums){
            if(num < pivot){
                ans[ind++] = num;
            }
        }

        for(int num : nums){
            if(num == pivot){
                ans[ind++] = num;
            }
        }

        for(int num : nums){
            if(num > pivot){
                ans[ind++] = num;
            }
        }
        return ans;
    }
}
//t.c = O(n)
//s.c = O(n) (output array)


// class Solution {
//     public int[] pivotArray(int[] nums, int pivot) {
//         int n = nums.length;
//         int cnt = 0;
//         ArrayList<Integer> list1 = new ArrayList<>();
//         ArrayList<Integer> list2 = new ArrayList<>();

//         for(int i = 0 ; i < n ; i++){
//             if(nums[i] < pivot) list1.add(nums[i]);
//             else if(nums[i] == pivot) cnt++;
//             else list2.add(nums[i]);
//         }

//         int[] ans = new int[n];
//         int i = 0;
//         while(i != list1.size()){
//             ans[i] = list1.get(i);
//             i++;
//         }
//         while(cnt != 0){
//             ans[i] = pivot;
//             i++;
//             cnt--;
//         }
//         int j = 0;
//         while(j != list2.size()){
//             ans[i] = list2.get(j);
//             j++;
//             i++;
//         }
//         return ans;
//     }
// }