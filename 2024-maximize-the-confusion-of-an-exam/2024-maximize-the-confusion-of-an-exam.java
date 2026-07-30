class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();

        int left = 0, cnt = 0, ans = 0;

        for(int i = 0 ; i < n ; i++){
            if(answerKey.charAt(i) == 'F'){
                cnt++;
            }

            while(cnt > k){
                if(answerKey.charAt(left) == 'F'){
                    cnt--;
                }
                left++;
            }

            ans = Math.max(ans, i - left + 1);
        }

        cnt = 0; left = 0;

        for(int i = 0 ; i < n ; i++){
            if(answerKey.charAt(i) == 'T'){
                cnt++;
            }

            while(cnt > k){
                if(answerKey.charAt(left) == 'T'){
                    cnt--;
                }
                left++;
            }

            ans = Math.max(ans, i - left + 1);
        }

        return ans;
    }
}