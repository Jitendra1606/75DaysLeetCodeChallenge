class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if(n == 1) return true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        int far = 0;

        while (!q.isEmpty()) {

            int i = q.poll();
            int start = Math.max(i + minJump, far + 1);
            int end = Math.min(i + maxJump, n - 1);

            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0') {
                    if (j == n - 1) return true;
                    q.offer(j);
                }
            }
            far = end;
        }
        return false;
    }
}
//t.c = O(n)
//s.c = O(n)

// Why far + 1?
// If far = 4, then:
// 0 → 4 already explored
// next unexplored index starts from: 5

//tle
// class Solution {
//     public boolean canReach(String s, int minJump, int maxJump) {
//         boolean[] visited = new boolean[s.length()];
//         return solve(s, 0, minJump, maxJump, visited);
//     }
//     public boolean solve(String s, int i, int min, int max, boolean[] visited){
//         if(i >= s.length() || s.charAt(i) == '1') return false;
//         if(visited[i]) return false;
//         if(i == s.length() - 1) return true;
//         visited[i] = true;
        
//         for(int jump = min; jump <= max ; jump++){
//             if(solve(s, i + jump, min, max, visited)) return true;
//         }
//         return false;
//     }
// }
