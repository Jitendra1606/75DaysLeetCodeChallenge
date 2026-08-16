class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int ans = Integer.MAX_VALUE;

        for(int rotations = 0 ; rotations < n ; rotations++){

            int ops = rotations; //current ops of rotating string

            for(int i = 0 ; i < n / 2 ; i++){

                char left = s.charAt((i + rotations) % n); //taking rotated value from front

                char right = s.charAt((n - 1 - i + rotations) % n); //taking rotated value from end

                int f1 = (right - left + 26) % 26; //we are not converting 
                int f2 = (left - right + 26) % 26; //any char, we are just

                //checking from where, there is a small path (a -> b -> .. -> z) or (a -> z)

                ops += Math.min(f1, f2);
            }

            ans = Math.min(ans, ops);
        }

        return ans;
    }
}