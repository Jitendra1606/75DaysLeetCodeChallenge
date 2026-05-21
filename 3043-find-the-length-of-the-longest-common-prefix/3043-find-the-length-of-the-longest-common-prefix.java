class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        
        Set<String> set = new HashSet<>();

        //for arr1
        for(int i = 0 ; i < arr1.length ; i++){
            
            String s = String.valueOf(arr1[i]);

            for(int j = 1 ; j <= s.length() ; j++){
                set.add(s.substring(0, j));
            }
        }
        
        int ans = 0;

        //for arr2
        for(int i = 0 ; i < arr2.length ; i++){

            String s = String.valueOf(arr2[i]);

            for(int j = 1 ; j <= s.length() ; j++){
                
                String pre = s.substring(0, j);

                if(set.contains(pre)){
                    ans = Math.max(ans, j);
                }
            }
        }
        return ans;
    }
}