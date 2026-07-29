class Solution{
    public int smallestDistancePair(int[] nums, int k){
        int n = nums.length;

        Arrays.sort(nums);

        int low = 0, high = nums[n - 1] - nums[0];

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(count(nums, mid) >= k){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    public int count(int[] nums, int mid){
        int n = nums.length;

        int cnt = 0, left = 0;

        for(int right = 0 ; right < n ; right++){

            while(nums[right] - nums[left] > mid){
                left++;
            }

            cnt += (right - left);
        }
        return cnt;
    }
}






// class Solution {
//     public int smallestDistancePair(int[] nums, int k) {
//         int n = nums.length;
//         List<Integer> list = new ArrayList<>();

//         for(int i = 0 ; i < n ; i++){
//             for(int j = i + 1 ; j < n ; j++){
//                 list.add(Math.abs(nums[i] - nums[j]));
//             }
//         }

//         Collections.sort(list);
//         return list.get(k - 1);
//     }
// }