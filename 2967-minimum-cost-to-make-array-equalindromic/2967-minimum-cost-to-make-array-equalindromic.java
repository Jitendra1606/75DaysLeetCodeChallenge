class Solution {
    public long minimumCost(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        long median = nums[n / 2]; //best candidate, just check for palindrome now

        long lower = median;
        long upper = median;

        while(!isPalindrome(lower)){
            lower--;
        }        

        while(!isPalindrome(upper)){
            upper++;
        }

        long cost1 = find(lower, nums);
        long cost2 = find(upper, nums);

        return Math.min(cost1, cost2);
    }

    public long find(long num, int[] nums){
        long sum = 0;

        for(int i = 0 ; i < nums.length ; i++){
            sum += (Math.abs(nums[i] - num));
        }
        return sum;
    }

    public boolean isPalindrome(long n){
        String s = Long.toString(n);

        int i = 0, j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}




// [10, 12, 13, 14, 15]
//          ↑
//       median = 13

// Without the palindrome restriction, the best target is 13.

// But 13 is not palindrome.

// So we check the closest palindrome below the median and the closest palindrome above the median:

// lower palindrome = 11
// upper palindrome = 22

// Then calculate the cost for both.