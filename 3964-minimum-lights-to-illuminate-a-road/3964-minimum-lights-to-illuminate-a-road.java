//question on difference array
class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;

        int[] diff = new int[n + 1]; //created a new array
        for(int i = 0 ; i < n ; i++){
            if(lights[i] > 0){ //first filling out array in the given range only
                int l = Math.max(0, i - lights[i]); //just simple difference array
                int r = Math.min(n - 1, i + lights[i]);

                diff[l] += 1; //just making it non zero only
                if(r + 1 < n){
                    diff[r + 1] -= 1;
                }
            }
        }
        for(int i = 1 ; i < n ; i++){ //prefix sum
            diff[i] = diff[i] + diff[i - 1];
        }
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            if(lights[i] == 0 && diff[i] == 0){ //checking where it is still 0
                cnt++;
                diff[i] = 1; //actually it can illuminate light at atmost 3 places
                if(i + 1 < n) diff[i + 1] = 1; //so we explicitily fill those 3 places
                if(i + 2 < n) diff[i + 2] = 1;
            }
        }
        return cnt;
    }
}