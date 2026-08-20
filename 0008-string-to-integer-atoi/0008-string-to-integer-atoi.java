class Solution{
    public int myAtoi(String s){
        return atoi(s);
    }

    public int atoi(String s){
        int i = 0;
        long num = 0;

        while(i < s.length() && s.charAt(i) == ' ') i++;

        int sign = 1;
        if(i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')){
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // return toDigit(s, i, 0, sign);

        while(i < s.length() && Character.isDigit(s.charAt(i))){
            num = num * 10 + (s.charAt(i) - '0');

            if(sign * num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign * num < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int)(sign * num);
    }

    // public int toDigit(String s, int i, long num, int sign){
    //     while(i < s.length() && Character.isDigit(s.charAt(i))){
    //         num = num * 10 + (s.charAt(i) - '0');

    //         if(num * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
    //         if(num * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;

    //         i++;
    //     }
    //     return (int)(sign * num);
    // }
}




















// class Solution{
//     public int myAtoi(String s) {
//         return atoi(s);
//     }

//     public int atoi(String s){
//         int i = 0;

//         while(i < s.length() && s.charAt(i) == ' ') i++;

//         int sign = 1;
//         if(i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')){
//             sign = (s.charAt(i) == '-') ? -1 : 1;
//             i++;
//         }

//         return todigit(s, i, 0, sign);
//     }

//     public int todigit(String s, int i, long num, int sign){
//         while(i < s.length() && Character.isDigit(s.charAt(i))){
//             num = num * 10 + (s.charAt(i) - '0');

//             if(num * sign > Integer.MAX_VALUE) return Integer.MAX_VALUE;
//             if(num * sign < Integer.MIN_VALUE) return Integer.MIN_VALUE;
//             i++;
//         }
//         return (int)num * sign;
//     }
// }
//t.c = O(n)
//s.c = O(n)


// class Solution {
//     public int myAtoi(String s) {
//         int i = 0;
//         int sign = 1;
//         int n = s.length();
//         long num = 0;

//         while (i < n && s.charAt(i) == ' ') {
//             i++;
//         }

//             if(i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')){
//             sign = (s.charAt(i) == '-') ? -1 : 1;
//             i++;
//         }

//         while(i < n && Character.isDigit(s.charAt(i))){
//             num = num * 10 + (s.charAt(i) - '0');

//             if(sign * num > Integer.MAX_VALUE){
//                 return Integer.MAX_VALUE;
//             }
//             if(sign * num < Integer.MIN_VALUE){
//                 return Integer.MIN_VALUE;
//             }
//             i++;
//         }
//         return (int)(sign * num);
//     }
// }
//t.c = O(n)
//s.c = O(1)