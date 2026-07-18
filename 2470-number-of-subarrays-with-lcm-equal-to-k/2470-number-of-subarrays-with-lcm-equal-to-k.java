class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            int lc = nums[i];

            for(int j = i ; j < n ; j++){
                lc = lcm(lc, nums[j]);

                if(lc > k) break;

                if(lc == k) cnt++;                
            }
        }
        return cnt;
    }

    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int lcm(int a, int b){
        int gc = gcd(a, b);

        return ((a * b) / gcd(a, b));
    }
}

// As you calculate the LCM of more numbers, it can only become greater. Once it becomes greater than k, you know that any larger subarrays containing all the current elements will not work.