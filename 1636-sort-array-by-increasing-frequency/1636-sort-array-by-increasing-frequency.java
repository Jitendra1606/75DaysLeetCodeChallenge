class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if(a.cnt == b.cnt) {
                    return b.num - a.num;
                }

                return a.cnt - b.cnt;
            }
        );

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){ //counting freq of each num
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int num : map.keySet()){ //putting in priorityQueue
            pq.offer(new Pair(num, map.get(num)));
        }

        int[] ans = new int[n];
        int i = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            int num = curr.num;
            int cnt = curr.cnt;

            while(cnt != 0){
                ans[i] = num;
                i++;
                cnt--;
            }
        }

        return ans;
    }
}

class Pair{
    int num;
    int cnt;

    Pair(int num, int cnt){
        this.num = num;
        this.cnt = cnt; 
    }
}