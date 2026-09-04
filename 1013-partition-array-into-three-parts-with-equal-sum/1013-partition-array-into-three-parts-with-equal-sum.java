class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int n = arr.length;

        int[] pre = new int[n];
        pre[0] = arr[0];

        for(int i = 1 ; i < n ; i++)
            pre[i] = pre[i - 1] + arr[i];
        
        int cnt = 0;
        int req = pre[n - 1] / 3;

        for(int i = 0 ; i < n ; i++){
            if(pre[i] == req){
                req += pre[n - 1] / 3;
                cnt++;
            }
        }

        return cnt >= 3 && pre[n - 1] % 3 == 0 ? true : false;
    } 
}