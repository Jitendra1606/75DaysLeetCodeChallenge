class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int open = n, close = n;
        solve(open, close, new StringBuilder(), result);
        return result;
    }

    public void solve(int open, int close, StringBuilder sb, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(sb.toString());
            return;
        }

        if (open != 0) {
            sb.append("(");
            solve(open - 1, close, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close > open) {
            sb.append(")");
            solve(open, close - 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}