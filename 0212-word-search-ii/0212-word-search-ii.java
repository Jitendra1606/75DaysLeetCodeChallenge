class Solution {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        
        int n = board.length;
        int m = board[0].length;

        HashSet<String> wordSet = new HashSet<>();
        HashSet<String> prefixSet = new HashSet<>();

        for(String word : words){
            wordSet.add(word); //adding elements of words array in hashset

            for(int i = 1 ; i <= word.length() ; i++){
                prefixSet.add(word.substring(0, i)); //this part is for optimization, discussed below
            }
        }

        HashSet<String> result = new HashSet<>();       
        boolean[][] vis = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){

                StringBuilder sb = new StringBuilder();
                sb.append(board[i][j]);

                solve(board, i, j, n, m, vis, sb, wordSet, prefixSet, result);
            }
        }

        return new ArrayList<>(result);
    }

    public void solve(char[][] mat, int i, int j, int n, int m, boolean[][] vis, StringBuilder sb, HashSet<String> wordSet, HashSet<String> prefixSet, HashSet<String> result){

        String current = sb.toString();

        if(!prefixSet.contains(current)){
            return;
        }

        if(wordSet.contains(current)){
            result.add(current);
        }

        vis[i][j] = true;

        for(int k = 0 ; k < 4 ; k++){

            int new_i = i + directions[k][0];
            int new_j = j + directions[k][1];

            if(new_i >= 0 && new_j >= 0 && new_i < n && new_j < m && !vis[new_i][new_j]){
                sb.append(mat[new_i][new_j]);

                solve(mat, new_i, new_j, n, m, vis, sb, wordSet, prefixSet, result);

                sb.deleteCharAt(sb.length() - 1);
            }
        }
        vis[i][j] = false;
    }
}


// prefixSet
// HashSet<String> prefixSet = new HashSet<>();
// Purpose
// Stores ALL prefixes of all words.

// Example:  word = "apple", Prefixes:
// "a"
// "ap"
// "app"
// "appl"
// "apple"

// All stored in prefixSet. Why needed?
// Suppose DFS currently made: "aq" ,Now check:

// prefixSet.contains("aq"), If false:

// NO word can ever start with "aq"
// so stop DFS immediately

// This is called:
// Prefix Pruning
// Very important optimization.