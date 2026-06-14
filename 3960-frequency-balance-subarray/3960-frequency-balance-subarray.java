class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        int maxLength = 0;

        for(int i = 0 ; i < n ; i++){
            HashMap<Integer, Integer> map = new HashMap<>();
            int maxFreq = 0;

            for(int j = i ; j < n ; j++){
                int currFreq = map.getOrDefault(nums[j], 0) + 1;
                map.put(nums[j], currFreq);

                maxFreq = Math.max(maxFreq, currFreq); //find max freq

                if(isValid(map, maxFreq)){
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    public boolean isValid(HashMap<Integer, Integer> map, int maxFreq){
        if(map.size() == 1) return true;

        if(maxFreq % 2 != 0) return false;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int freq = entry.getValue();

            if(freq == maxFreq) continue;

            if(freq != (maxFreq / 2)) return false;
        }
        return true;
    }
}