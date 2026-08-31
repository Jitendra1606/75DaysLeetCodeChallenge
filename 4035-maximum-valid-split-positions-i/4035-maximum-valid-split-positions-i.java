class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length;

        int max = 0;

        //case 1: no element removed
        int[] pre = new int[n];
        pre[0] = nums[0];

        for (int i = 1; i < n; i++) {
            pre[i] = gcd(pre[i - 1], nums[i]);
        }

        int[] suff = new int[n];

        suff[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suff[i] = gcd(suff[i + 1], nums[i]);
        }

        int cnt = 0; // Count valid splits without removing anything
        for (int i = 0; i < n - 1; i++) {
            if (pre[i] == suff[i + 1])
                cnt++;
        }

        max = Math.max(max, cnt);

        //case 2 : remove one element
        for (int i = 0; i < n; i++) {

            // Build array after removing nums[remove]
            int[] arr = new int[n - 1];
            int k = 0;

            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                arr[k++] = nums[j];
            }

            //new prefix gcd array, after removing a element
            int[] pr = new int[n - 1];
            pr[0] = arr[0];

            for (int j = 1; j < n - 1; j++) {
                pr[j] = gcd(pr[j - 1], arr[j]);
            }

            //new suffix gcd array, after removing a element
            int[] suf = new int[n - 1];
            suf[n - 2] = arr[n - 2];

            for (int j = n - 3; j >= 0; j--) {
                suf[j] = gcd(suf[j + 1], arr[j]);
            }

            cnt = 0; //cnt valid splits

            for (int j = 0; j < n - 2; j++) { //n - 2, bcz we've already
                if (pr[j] == suf[j + 1]) //removed a element
                    cnt++;
            }

            max = Math.max(max, cnt);
        }

        return max;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}