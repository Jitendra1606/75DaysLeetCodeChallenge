class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;

        Set<List<Integer>> set = new HashSet<>();

        for(int i = 0 ; i < n ; i++){
            List<Integer> list = new ArrayList<>();
            int cnt = 0;

            for(int j = i ; j < n ; j++){
                if(nums[j] % p == 0){
                    cnt++;
                }

                if(cnt > k) break;

                list.add(nums[j]);
                set.add(new ArrayList<>(list));
            }
        }

        return set.size(); 
    }
}