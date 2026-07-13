class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int lowDigits = (int)Math.log10(low) + 1;
        int highDigits =(int)Math.log10(high) + 1;
        highDigits = Math.min(highDigits, 9);

        String number = "123456789";

        List<Integer> ans = new ArrayList<>();
        int i = 0, j = lowDigits;

        while(lowDigits <= highDigits){
            int num = Integer.valueOf(number.substring(i, j));

            if(num >= low && num <= high){
                ans.add(num);
            }

            i++; j++;

            if(j > 9){
                lowDigits++;
                if(lowDigits > highDigits)
                    break;
                i = 0;
                j = lowDigits;
            }
        }
        return ans;
    }
}
// class Solution {
//     public List<Integer> sequentialDigits(int low, int high) {
//         int lowDigits = (int)Math.log10(low) + 1;
//         int highDigits =(int)Math.log10(high) + 1;
//         String number = "123456789";
//         List<Integer> ans = new ArrayList<>();
//         int i = 0, j = lowDigits;

//         while(j - i <= 9){
//             int num = Integer.valueOf(number.substring(i, j));

//             if(num >= low && num <= high){
//                 ans.add(num);
//             }else if(num > high) break;
//             i++; j++;

//             if(j > 9){
//                 i = 0;
//                 j = lowDigits + 1;
//                 lowDigits++;
//             }
//         }
//         return ans;
//     }
// }