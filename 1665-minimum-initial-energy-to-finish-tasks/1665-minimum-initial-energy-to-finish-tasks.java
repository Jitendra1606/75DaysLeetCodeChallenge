class Solution {
    public int minimumEffort(int[][] tasks) {
        int n = tasks.length;

        int start = 0;
        int end = (int)1e9; // value can be this big, so safe option is choosing it initially

        int result = Integer.MAX_VALUE;

        //sorting according to differences 
        Arrays.sort(tasks, (task1, task2) ->{
            int dif1 = task1[1] - task1[0];
            int dif2 = task2[1] - task2[0];

            return dif2 - dif1;
        });

        //noraml binary search on answers tempelate
        while(start <= end){
            
            int mid = start + (end - start) / 2;

            if(isPossible(tasks, mid)){
                result = mid;
                end = mid - 1; 
            }
            else{
                start = mid + 1;
            }
        }
        return result;
    }

    public boolean isPossible(int[][] tasks, int mid){

        for(int[] task : tasks){ //as now the array is already sorted

            int actual = task[0]; //acc to question
            int minimum = task[1]; 

            if(minimum > mid) { //if condition fails already
                return false;
            }

            mid -= actual; //o/w do the simple calculation
        }

        return true;
    }
}