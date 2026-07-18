// % 25 = 00, 25, 50, 75
class Solution {
    public int minimumOperations(String num) {
        char[] arr = num.toCharArray();

        int n = arr.length;

        Set<Integer> set = new HashSet<>();
        set.add(00);
        set.add(25);
        set.add(50);
        set.add(75);

        int ans = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++){

            if(arr[i] == '0') ans = Math.min(ans, n - 1);

            for(int j = i + 1 ; j < n ; j++){
                int dig = (arr[i] - '0') * 10 + (arr[j] - '0');

                if(set.contains(dig)) {
                    ans = Math.min(ans, n - i - 2);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? n : ans;
    }
}

// Delete everything after j: n - 1 - j
// Delete everything between i and j: j - i - 1

// Total:

// (n - 1 - j) + (j - i - 1)
// = n - i - 2