class Solution {
    public int findMin(int[] nums) {
        
        int n = nums.length;
        int low = 0, high = n - 1;

        while(low < high){

            int mid = low + (high - low) / 2;

            if(nums[mid] > nums[high]){//minimum is in right half.
                low = mid + 1;
            }
            else if(nums[mid] < nums[high]){
                high = mid; //minimum lies in left half including mid.
            }
            else{
                high--;
            }
        }
        return nums[low];
    }
}
//t.c = O(n), worst case, o/w O(log n)
//s.c = O(1)