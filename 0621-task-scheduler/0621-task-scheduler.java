class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] freq = new int[26];
        for(char ch : tasks){
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i < 26 ; i++){
            if(freq[i] > 0){
                pq.offer(freq[i]);
            }
        }

        int time = 0;

        while(!pq.isEmpty()){
            List<Integer> list = new ArrayList<>();

            int work = 0;

            for(int i = 1 ; i <= n + 1 ; i++){

                if(!pq.isEmpty()){

                    int curfreq = pq.poll();
                    if(curfreq > 1){
                        list.add(curfreq - 1);
                    }

                    work++;
                }
            }
//storing elements in the list temporary to keep track of elements
            for(int f : list){ //again pushing back to pq
                if(f > 0) pq.offer(f);
            }

            if(pq.isEmpty()){
                time += work;
            }
            else{
                time += (n + 1);
            }
        }
        return time;
    }
}

//no need to store characters with frequencies bcz we will pop out the character when we use it so there will be no mess of using the same character with heigher frequency bcz it will not present in the pq at that moment
//ans also we always need the char with high freq to be at top that's why we use max heap 
//for any particular char it's next occurence must be after n times that's why we are sunning loop to n + 1 times so that same char will automatically come after n times