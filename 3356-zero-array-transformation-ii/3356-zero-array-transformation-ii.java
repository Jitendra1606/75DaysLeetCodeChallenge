// The easiest approach: Binary Search, there is an important observation:
// If the first k queries can make the array zero, then the first k+1 queries can also make it zero.
// So we can binary search for the minimum number of queries.

class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;

        //already zero
        boolean alreadyZero = true;
        for(int x : nums){
            if(x != 0) {
                alreadyZero = false;
                break;
            }
        }

        if(alreadyZero) return 0;

        //impossible even after all queries
        if(!check(nums, queries, q)) return -1;

        int low = 1, high = q;

        while(low < high){
            int mid = low + (high - low) / 2;

            if(check(nums, queries, mid)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean check(int[] nums, int[][] queries, int q){
        int n = nums.length;

        int[] diff = new int[n + 1];

        for (int i = 0; i < q ; i++) {
            int first = queries[i][0];
            int second = queries[i][1];
            int val = queries[i][2];

            diff[first] += val; //instead of decrementing we add value
            diff[second + 1] -= val; //to keep track of how much we can subtract
        }
        
        int cur = 0;

        for(int i = 0 ; i < n ; i++){
            cur += diff[i];//curr = total decrement available at index i

            if(cur < nums[i]) return false;
        }
        return true;
    }
}