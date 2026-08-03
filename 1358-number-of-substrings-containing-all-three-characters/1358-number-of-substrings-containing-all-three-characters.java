class Solution{
    public int numberOfSubstrings(String s){
        int n = s.length();

        int[] arr = new int[3];
        int left = 0, ans = 0;

        for(int right = 0 ; right < n ; right++){
            char ch = s.charAt(right);

            arr[ch - 'a']++;

            while(arr[0] > 0 && arr[1] > 0 && arr[2] > 0){
                char c = s.charAt(left);

                arr[c - 'a']--;

                ans += (n - right); // it contains all the possible subarrays
                left++;
            }
        }
        return ans;
    }
}













// class Solution {
//     public int numberOfSubstrings(String s) {
//         int n = s.length();
//         int ans = 0;
//         int[] arr = new int[3]; 
//         int left = 0;

//         for(int i = 0 ; i < n ; i++){
//             char ch = s.charAt(i);

//             arr[ch - 'a']++;

//             while(arr[0] > 0 && arr[1] > 0 && arr[2] > 0){
//                 ans += n - i;

//                 arr[s.charAt(left) - 'a']--;
//                 left++;
//             }
//         }
//         return ans;
//     }
// }