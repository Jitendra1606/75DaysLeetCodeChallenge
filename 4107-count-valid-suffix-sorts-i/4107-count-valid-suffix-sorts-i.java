class Solution {
    public int countSuffix(int[] nums, int[] target) {
        int n = nums.length;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            map1.put(nums[i], map1.getOrDefault(nums[i], 0) + 1);
            map2.put(target[i], map2.getOrDefault(target[i], 0) + 1);
        }

        if(!map1.equals(map2)) return 0;

        int ans = 0, maxi = n - 1, mini = 0;

        for(int i = 0 ; i < n ; i++){
            if(nums[i] != target[i]){
                maxi = i;
                break;
            }
        }

        for(int i = n - 1 ; i > 0 ; i--){
            if(target[i] > target[i - 1]){
                mini = i;
                break;
            }
        }

        ans = Math.max(0, maxi - mini + 1);

        return ans;
    }
}