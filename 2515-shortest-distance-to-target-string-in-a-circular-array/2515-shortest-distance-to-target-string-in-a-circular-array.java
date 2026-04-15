class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < words.length ; i++){
            set.add(words[i]);
        }
        int n = words.length;
        if(!set.contains(target)) return -1;
        int cnt1 = 0, cnt2 = 0;
        for(int i = startIndex ; ; i = (i + 1) % n){
            if(words[i].equals(target)){
                break;
            }
            cnt1++;
        }
        for(int i = startIndex ; ; i = (i - 1 + n) % n){
            if(words[i].equals(target)){
                break;
            }
            cnt2++;
        }
        return Math.min(cnt1, cnt2);
    }
}