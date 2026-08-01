class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int n = tasks.length;
        int m = workers.length;

        Arrays.sort(tasks);
        Arrays.sort(workers);

        int low = 1, high = Math.min(m, n), ans = 0;

        while(low <= high){

            int mid = low + (high - low) / 2;

            if(isPossible(tasks, workers, pills, strength, mid, m)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] tasks, int[] workers, int pills, int strength, int k, int m){
        int[] tasksk = new int[k];
        int[] workersk = new int[k];

        for(int i = 0 ; i < k ; i++) tasksk[i] = tasks[i]; //asc
        for(int i = 0 ; i < k ; i++) workersk[i] = workers[m - k + i]; //desc

        for(int i = k - 1 ; i >= 0 && pills > 0 ; i--){
            if(tasksk[i] > workersk[i]){
                tasksk[i] -= strength;
                pills--;
            }
        }

        Arrays.sort(tasksk);

        for(int i = 0 ; i < k ; i++){
            if(workersk[i] < tasksk[i]) return false;
        }

        return true;
    }
}