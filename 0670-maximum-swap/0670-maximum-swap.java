class Solution {
    public int maximumSwap(int num) {
        String s = Integer.toString(num);
//first, converting to string and finding the first greater number from the left
        int n = s.length();
//storing as an int arr
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = s.charAt(i) - '0';
        }

        for(int i = 0 ; i < n ; i++){
            int maxIndex = i;
            int max = 0;

            for(int j = i ; j < n ; j++){
                if(arr[j] >= max){
                    max = arr[j];
                    maxIndex = j;
                }
            }
//finding the number and then swapping it with leftmost number
            if(arr[maxIndex] != arr[i]){
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
                break;
            }
        }
//converting back to normal int
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            ans = ans * 10 + arr[i];
        }

        return ans;
    }
}