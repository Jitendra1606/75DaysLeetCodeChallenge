class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        int max = 0; //largest number to stop early for primes

        for (int num : nums)
            max = Math.max(max, num);

        //generate primes up to max only
        List<Integer> primes = getPrimes(max);

        //store distinct primes factors of each number
        List<List<Integer>> factors = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            factors.add(fact(nums[i], primes));
        }

        //freq[p] = no. of elements in current window that contains prime p
        int[] freq = new int[max + 1];

        int distinct = 0, left = 0, res = 0;

        //expand window using right
        for (int right = 0; right < n; right++) {

            //add nums[right]
            for (int p : factors.get(right)) {
                if (freq[p] == 0) {
                    distinct++;
                }

                freq[p]++;
            }

            //shrink the window while invalid
            while (distinct > k) {

                for (int p : factors.get(left)) {
                    freq[p]--;

                    if (freq[p] == 0)
                        distinct--;
                }

                left++;
            }

            //current window is valid
            res = Math.max(res, right - left + 1);
        }

        return res;
    }

    //generating all primes till max
    public List<Integer> getPrimes(int n) {

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);

        if (n >= 0)
            isPrime[0] = false;
        if (n >= 1)
            isPrime[1] = false;

        List<Integer> prime = new ArrayList<>();

        for (int i = 2; i <= n; i++) {

            if (isPrime[i]) {
                prime.add(i);

                //mark all the multiples of i as composite
                if ((long) i * i <= n) {

                    for (int j = i * i; j <= n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return prime;
    }

    //precompute all the distinct prime factors of n
    public List<Integer> fact(int n, List<Integer> prime) {
        List<Integer> factors = new ArrayList<>();

        for (int p : prime) {

            if ((long) p * p > n)
                break; //no need continue after sqrt(n)

            if (n % p == 0) {

                //add this preime only once and remove all its multiples
                factors.add(p);

                while (n % p == 0) {
                    n = n / p;
                }
            }
        }

        //if something gretaer than 1 remains, it is prime
        if (n > 1)
            factors.add(n);

        return factors;
    }
}