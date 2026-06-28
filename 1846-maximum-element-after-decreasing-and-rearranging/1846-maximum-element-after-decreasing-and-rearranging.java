class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int cnt = 0;

        Arrays.sort(arr);
        if(arr[0] != 1){
            arr[0] = 1;
            cnt++;
        }

        for(int i = 1 ; i < n ; i++){
            if(Math.abs(arr[i] - arr[i - 1]) > 1){
                arr[i] = arr[i - 1] + 1;
                cnt++;
            }
        }
        return arr[n - 1];
    }
}