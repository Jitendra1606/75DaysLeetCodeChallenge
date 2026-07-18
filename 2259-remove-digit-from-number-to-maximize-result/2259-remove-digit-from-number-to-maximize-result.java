class Solution{
    public String removeDigit(String number, char digit){
        String max = "";

        for(int i = 0 ; i < number.length() ; i++){
            if(number.charAt(i) == digit){
                String candidate = number.substring(0, i) + number.substring(i + 1);

                if(candidate.compareTo(max) > 0){
                    max = candidate;
                }
            }
        }
        return max;
    }
}

//Since all candidate strings have the same length, lexicographical comparison works.



//NumberFormatException - "2998589353917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471"
// class Solution {
//     public String removeDigit(String number, char digit) {
//         char[] arr = number.toCharArray();

//         int max = 0;
//         for(int i = 0 ; i < arr.length ; i++){
//             if(arr[i] == digit){
//                 max = Math.max(max, compare(arr, i));
//             }
//         }
//         return Integer.toString(max);
//     }

//     public int compare(char[] arr, int x){
//         String s = new String(arr);
//         String s1 = s.substring(0, x);
//         String s2 = s.substring(x + 1);

//         return Integer.parseInt(s1 + s2);
//     }
// }