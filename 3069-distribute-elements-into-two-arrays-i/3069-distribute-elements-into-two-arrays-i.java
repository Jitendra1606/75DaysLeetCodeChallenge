class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        if(n == 1) return nums;

        int[] result = new int[n];

        list1.add(nums[0]);
        list2.add(nums[1]);

        for(int i = 2 ; i < n ; i++){
            if(list1.get(list1.size() - 1) > list2.get(list2.size() - 1)){
                list1.add(nums[i]);
            }else{
                list2.add(nums[i]);
            }
        }

        int ind = 0;
        for(int h = 0 ; h < list1.size() ; h++){
            result[ind++] = list1.get(h);
        }

        for(int h = 0 ; h < list2.size() ; h++){
            result[ind++] = list2.get(h);
        }

        return result;
    }
}