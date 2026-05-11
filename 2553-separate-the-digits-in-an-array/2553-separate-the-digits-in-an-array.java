class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            solve(nums[i], list);
        }
        int[] arr = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
    public void solve(int n, ArrayList<Integer> list){
        ArrayList<Integer> list2 = new ArrayList<>();
        while(n != 0){
            int rem = n % 10;
            list2.add(rem);
            n = n / 10;
        }
        Collections.reverse(list2);
        list.addAll(list2);
    }
}