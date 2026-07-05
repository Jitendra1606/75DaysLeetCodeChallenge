//Find the longest palindromic subarray (by length). Its sum will automatically be maximum. As the elements of array are positive.
//This looks exactly like Longest Palindromic Substring. String problem:"abacaba", Array problem:[1,2,3,2,1]

class Solution{
    public long getSum(int[] nums){
        int n = nums.length;

        long[] prefix = new long[n + 1];
        for(int i = 0 ; i < n ; i++){
            prefix[i + 1] = prefix[i] + nums[i]; 
        }

        int[] odd = new int[n];
        int l = 0, r = -1;

        //Manacher odd
        for(int i = 0 ; i < n ; i++){
            int k;

            if(i > r){
                k = 1;
            }
            else{
                int mirror = l + r - i;
                k = Math.min(odd[mirror], r - i + 1);
            }

            while(i - k >= 0 && i + k < n && nums[i - k] == nums[i + k]){
                k++;
            }

            odd[i] = k;

            if(i + k - 1 > r){
                l = i - k + 1;
                r = i + k - 1;
            }
        }

        int[] even = new int[n];
        l = 0;
        r = -1;

        //Manacher even
        for(int i = 0 ; i < n ; i++){
            int k;

            if(i > r){
                k = 0;
            }
            else{
                int mirror = l + r - i + 1;
                k = Math.min(even[mirror], r - i + 1);
            }

            while(i - k - 1 >= 0 && i + k < n && nums[i - k - 1] == nums[i + k]){
                k++;
            }

            even[i] = k;

            if(i + k - 1 > r){
                l = i - k;
                r = i + k - 1;
            }
        }

        long ans = 0;

        //odd palindromes
        for(int i = 0 ; i < n ; i++){
            int radius = odd[i];

            int left = i - radius + 1;
            int right = i + radius - 1;

            long sum = prefix[right + 1] - prefix[left];
            ans = Math.max(ans, sum);
        }

        //even palindromes
        for(int i = 0 ; i < n ; i++){
            int radius = even[i];

            if(radius == 0) continue;

            int left = i - radius;
            int right = i + radius - 1;

            long sum = prefix[right + 1] - prefix[left];
            ans = Math.max(ans, sum); 
        }
        return ans;
    }
}



// brute
// class Solution {
//     public long getSum(int[] nums) {
//         int n = nums.length;

//         long max = 0;
//         for(int i = 0 ; i < n ; i++){
//             long sum = 0;
//             for(int j = i ; j < n ; j++){
//                 sum += nums[j];
//                 if(isPalindrome(i, j, nums)){
//                     max = Math.max(max, sum);
//                 }
//             }
//         }
//         return max;
//     }

//     public boolean isPalindrome(int i, int j, int[] nums){
//         while(i <= j){
//             if(nums[i] != nums[j]) return false;
//             i++;
//             j--;
//         }
//         return true;
//     }
// }