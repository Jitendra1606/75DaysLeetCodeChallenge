class Solution {
    public List<String> validStrings(int n) {
        List<String> list = new ArrayList<>();
        solve(n, 0, new StringBuilder(), list);
        return list;
    }

    public void solve(int n, int ind, StringBuilder sb, List<String> list){
        
        if(ind == n){
            list.add(sb.toString());
            return;
        }

        sb.append(1);
        solve(n, ind + 1, sb, list);
        sb.deleteCharAt(sb.length() - 1);

        if(sb.length() == 0 || sb.charAt(sb.length() - 1) != '0'){
            sb.append(0);
            solve(n, ind + 1, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}