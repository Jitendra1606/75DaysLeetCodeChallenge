class Solution{
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks){
        int n = rocks.length;

        //first we will find how many rocks are needed at which index
        int[] need = new int[n];

        for(int i = 0 ; i < n ; i++){
            need[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(need); //then we will sort it to find the min first
        
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            if(need[i] <= additionalRocks){
                cnt++;
                
                additionalRocks -= need[i];

            }else{
                break;
            }
        }
        return cnt;
    }
}




//wrong approach according to this question but i don't know why
// class Solution {
//     public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
//         int n = rocks.length;
//         int cnt = 0;

//         int[][] arr = new int[n][2];
//         for(int i = 0 ; i < n ; i++){
//             arr[i][0] = rocks[i];
//             arr[i][1] = capacity[i];
//         }

//         Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

//         for(int i = 0 ; i < n ; i++){

//             int first = arr[i][0];
//             int second = arr[i][1];
//             int diff = second - first;

//             if(diff == 0){
//                 cnt++;
//             }
//             else if(diff <= additionalRocks){
//                 additionalRocks -= diff;
//                 cnt++;
//             }
//         }
//         return cnt;
//     }
// }