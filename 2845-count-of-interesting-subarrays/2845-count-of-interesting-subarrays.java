class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int n = nums.size();

        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);

        long ans = 0;
        int prefix = 0;

        for(int x : nums){

            if(x % modulo == k) prefix++;

            int cur = prefix % modulo;

            int need = (cur - k + modulo) % modulo;

            ans += map.getOrDefault(need, 0);

            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        return ans;
    }
}