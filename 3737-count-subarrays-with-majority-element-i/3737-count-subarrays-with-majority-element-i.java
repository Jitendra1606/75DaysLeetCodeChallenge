class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = i ; j < n ; j++){
                int len = j - i + 1;

                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

                if(isValid(map, target, len)) cnt++;
            }
        }
        return cnt;
    }

    public boolean isValid(HashMap<Integer, Integer> map, int tar, int len){
        int freq = map.getOrDefault(tar, 0);
        return freq > len / 2;
    }
}