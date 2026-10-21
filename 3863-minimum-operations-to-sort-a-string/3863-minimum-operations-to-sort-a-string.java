class Solution{
    public int minOperations(String s){
        int n = s.length();

        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String str = new String(arr);
        
        if(str.equals(s)) return 0;
        if(n == 2) return -1;

        char min = str.charAt(0);
        char max = str.charAt(n - 1);
        
        if(s.charAt(0) == str.charAt(0) || s.charAt(n - 1) == str.charAt(n - 1)) return 1;

        for(int i = 1 ; i < n - 1 ; i++){
            if(s.charAt(i) == min || s.charAt(i) == max) return 2;
        }

        return 3;
    }
}


// class Solution {
//     public int minOperations(String s) {
//         int n = s.length();
//         char[] str = s.toCharArray();
//         Arrays.sort(str);
//         String sorted = new String(str);

//         if(s.equals(sorted)) return 0;
//         if(n == 2) return -1;

//         if(s.charAt(0) == sorted.charAt(0) || s.charAt(n - 1) == sorted.charAt(n - 1)){
//             return 1;
//         }
//         if(s.charAt(0) == sorted.charAt(n - 1) || s.charAt(n - 1) == sorted.charAt(0)){
//             return 2;
//         }
//         return 3;
//     }
// }