class Solution {
    public int minimumPushes(String word) {
        int n = word.length();

        int[] hash = new int[26];
        for(int i = 0 ; i < n ; i++){
            hash[word.charAt(i) - 'a']++;
        }

        Arrays.sort(hash);
        for(int i = 0 ; i < 13 ; i++){
            int temp = hash[i];
            hash[i] = hash[26 - i - 1];
            hash[26 - i - 1] = temp;
        }

        int cnt = 0, i = 0, sum = 0;
        while(i < 26 && hash[i] != 0){
            if(cnt < 8){
                sum += (hash[i]);
            }
            else if(cnt >= 8 && cnt < 16){
                sum += 2 * (hash[i]);
            }
            else if(cnt >= 16 && cnt < 24){
                sum += 3 * (hash[i]);
            }
            else{
                sum += 4 * (hash[i]);
            }
            cnt++;
            i++;
        }
        return sum;
    }
}