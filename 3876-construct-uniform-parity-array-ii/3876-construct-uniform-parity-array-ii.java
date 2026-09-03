class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;

        int even = 0, odd = 0, min = Integer.MAX_VALUE;

        for (int num : nums1) {

            min = Math.min(min, num);

            if (num % 2 == 0)
                even++;
            else
                odd++;
        }

        if (even == 0 || odd == 0)
            return true;

        if (min % 2 == 0)
            return false;

        return true;
    }
}