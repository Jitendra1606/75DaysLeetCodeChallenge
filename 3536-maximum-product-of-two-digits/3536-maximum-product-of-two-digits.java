class Solution{
    public int maxProduct(int n){
        int first = 0, second = 0;

        while(n > 0){
            int rem = n % 10;

            if(rem > first){
                second = first;
                first = rem;
            }
            else if(rem > second){
                second = rem;
            }

            n = n / 10;
        }

        return first * second;
    }
}




// class Solution {
//     public int maxProduct(int n) {
//         String s = Integer.toString(n);
//         char[] arr = s.toCharArray();
//         Arrays.sort(arr);

//         return (arr[arr.length - 1] - '0') * (arr[arr.length - 2] - '0');
//     }
// }