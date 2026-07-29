class Solution {
    public int findBestValue(int[] arr, int target) {
        int n = arr.length;

        int low = 0;
        int high = 0;
        for(int num : arr) high = Math.max(num, high);

        while(low <= high){

            int mid = low + (high - low) / 2;
            int res = isPossible(arr, mid);

            if(res >= target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        int sum1 = isPossible(arr, low);
        int sum2 = isPossible(arr, low - 1);

        if(Math.abs(sum2 - target) <= Math.abs(sum1 - target)){
            return low - 1;
        }

        return low;
    }

    public int isPossible(int[] arr, int mid){
        int n = arr.length;
        int sum = 0;

        for(int i = 0 ; i < n ; i++){
            sum += Math.min(mid, arr[i]);
        }

        return sum;
    }
}