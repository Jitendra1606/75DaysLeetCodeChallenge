class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int cnt = 0;
        for(int i = 1 ; i < arrays.size() ; i++){
            int cur_min = arrays.get(i).get(0);
            int cur_max = arrays.get(i).get(arrays.get(i).size() - 1);
            cnt = Math.max(cnt, Math.abs(cur_max - min));
            cnt = Math.max(cnt, Math.abs(max - cur_min));
            min = Math.min(min, cur_min);
            max = Math.max(max, cur_max);
        }
        return cnt;
    }
}
