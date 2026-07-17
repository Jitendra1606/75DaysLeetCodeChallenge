class Solution{
    public int monotoneIncreasingDigits(int n){
        String s = Integer.toString(n);
        char[] arr = s.toCharArray();

        int mark = arr.length;

        for(int i = arr.length - 1 ; i > 0 ; i--){
            if(arr[i - 1] > arr[i]){
                arr[i - 1]--;
                mark = i;
            }
        }

        for(int i = mark ; i < arr.length ; i++){
            arr[i] = '9';
        }
        
        return Integer.parseInt(new String(arr));
    }
}



// n = 123454321

// Find first violation from the right.
// 1 2 3 4 5 4 3 2 1

// Decrease:
// 1 2 3 4 4 4 3 2 1

// Fill the rest with 9:
// 1 2 3 4 4 9 9 9 9
// Answer:
// 123449999




// class Solution {
//     public int monotoneIncreasingDigits(int n) {
//         long x = n;
//         for(long i = x ; i >= 0 ; i--){
//             if(correct(i)){
//                 return (int)i;
//             }
//         }
//         return 0;
//     }

//     public boolean correct(long n){
//         String s = Long.toString(n);
//         char[] arr = s.toCharArray();

//         for(int i = 0 ; i < arr.length - 1 ; i++){
//             if((s.charAt(i) - '0') > (s.charAt(i + 1) - '0')) return false;
//         }
//         return true;
//     }
// }