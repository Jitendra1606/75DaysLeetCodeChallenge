//hme ek pair ko sirf ek baar hi use krna h, to ek pair ki occurence ke baad uska freq cnt 0 ho jana chahiye bs

class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for(int i = 0 ; i < n ; i++){
            int rem = k - nums[i];

            if(map.getOrDefault(rem, 0) > 0){ //for one pair, when 1st value comes it is zero
                res++; //and when 2nd value comes it's > 0 & we remove it. so it becomes zero.

                map.put(rem, map.get(rem) - 1);//decrease cnt of freq by 1
            }else{
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return res;
    }
}