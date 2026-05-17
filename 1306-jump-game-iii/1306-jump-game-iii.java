//doing dfs
class Solution{
    public boolean canReach(int[] arr, int start){
        boolean[] visited = new boolean[arr.length];
        return solve(arr, start, visited);
    }
    public boolean solve(int[] arr, int s, boolean[] visited){
        if(s < 0 || s >= arr.length) return false;
        if(visited[s]) return false;
        if(arr[s] == 0) return true;
        visited[s] = true;
        return solve(arr, s + arr[s], visited) || solve(arr, s - arr[s], visited);
    } 
}

// class Solution {
//     public boolean canReach(int[] arr, int start) {
//         int n = arr.length;
//         return solve(arr, start, n);
//     }
//     public boolean solve(int[] arr, int s, int n){
        
//         if(s >= n || s < 0) return false;

//         if(arr[s] == 0) return true;

//         if(arr[s] < 0) return false; //visited check

//         int jump = arr[s];

//         arr[s] = -arr[s]; //marking visited

//         int plus = s + jump;

//         int minus = s - jump;
        
//         return solve(arr, plus, n) || solve(arr, minus, n);
//     }
// }