class Solution {
    public boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        boolean ok = false;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] >= nums[i + 1])
                ok = true;
        }

        if (!ok) //means already strictly greater
            return true;

        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);

        List<Integer> prime = getPrime(max);

        for (int i = n - 1; i > 0; i--) {
            if (nums[i] <= nums[i - 1]) {

                int diff = nums[i - 1] - nums[i];

                //first prime > diff
                int index = upperBound(prime, diff);

                //no such prime
                if (index == prime.size())
                    return false;

                int p = prime.get(index);

                //prime must be smaller then nums[i - 1]
                if (p >= nums[i - 1]) //e.g nums = [2,2]
                    return false;

                nums[i - 1] -= p;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] >= nums[i + 1])
                return false;
        }

        return true;

    }

    public List<Integer> getPrime(int n) {
        List<Integer> list = new ArrayList<>();

        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        if (n >= 0)
            primes[0] = false;
        if (n >= 1)
            primes[1] = false;

        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                list.add(i);
                if ((long) i * i <= n) {
                    for (int j = i * i; j <= n; j += i) {
                        primes[j] = false;
                    }
                }
            }
        }
        return list;
    }

    static int upperBound(List<Integer> list, int x) {
        int low = 0, high = list.size();

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) <= x)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }
}