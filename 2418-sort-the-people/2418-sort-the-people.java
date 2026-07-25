class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        String[] ans = new String[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for(int i = 0 ; i < n ; i++){
            pq.offer(new int[]{heights[i], i});
        }
        for(int i = 0 ; i < n ; i++){
            int[] top = pq.poll();
            ans[i] = names[top[1]];
        }
        return ans;
    }
}