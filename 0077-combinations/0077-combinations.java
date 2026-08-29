class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        solve(1, k, n, new ArrayList<>(), result);

        return result;
    }

    public void solve(int ind, int k, int n, List<Integer> list, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = ind; i <= n; i++) {
            list.add(i);

            solve(i + 1, k - 1, n, list, result);

            list.remove(list.size() - 1);
        }
    }
}

// class Solution {
//     public List<List<Integer>> combine(int n, int k) {
//         List<List<Integer>> result = new ArrayList<>();
//         solve(n, k, 1, new ArrayList<>(), result);
//         return result;
//     }

//     public void solve(int n, int k, int idx, List<Integer> list, List<List<Integer>> result){

//         if(k == 0){
//             result.add(new ArrayList<>(list));
//             return;
//         }

//         for(int i = idx ; i <= n ; i++){
//             list.add(i);
//             solve(n, k - 1, i + 1, list, result);
//             list.remove(list.size() - 1);
//         }
//     }
// }