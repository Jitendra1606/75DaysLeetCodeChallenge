//this is exact follow up of Word Ladder-I

class Solution {
    char[] arr = {'A', 'C', 'G', 'T'};
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(startGene, 0));

        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < bank.length ; i++){
            set.add(bank[i]);
        }
        set.remove(startGene);

        while(!q.isEmpty()){
            String word = q.peek().first;
            int cnt = q.peek().second;

            q.poll();
            if(word.equals(endGene)) return cnt;

            for(int i = 0 ; i < 8 ; i++){
                for(int j = 0 ; j < 4 ; j++){
                    char[] replacedCharArray = word.toCharArray();

                    replacedCharArray[i] = arr[j];

                    String replacedWord = new String(replacedCharArray);

                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.offer(new Pair(replacedWord, cnt + 1));
                    }
                }
            }
        }
        return -1;
    }
}

class Pair{
    String first;
    int second;

    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}