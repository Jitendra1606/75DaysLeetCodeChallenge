class Solution{
    final static int MOD = (int)(1e9 + 7);

    public int countPairs(int[] arr){
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();

        int res = 0;
        for(int i = 0 ; i < n ; i++){
            int power = 1;

            for(int j = 0 ; j < 22 ; j++){
                if(map.containsKey(power - arr[i])){
                    res += map.get(power - arr[i]);
                    res %= MOD;
                }
                power *= 2;
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return res;
    }
}
