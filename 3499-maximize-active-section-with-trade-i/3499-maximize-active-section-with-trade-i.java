class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();

        //cnt of 1's
        int activeCnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(s.charAt(i) == '1') activeCnt++;
        }

        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(i < n){
            if(s.charAt(i) == '0'){

                int start = i;
                while(i < n && s.charAt(i) == '0'){
                    i++;
                }
                list.add(i - start);
            }else{
                i++;
            }
        }

        int max = 0;
        for(int j = 1 ; j < list.size() ; j++){
            max = Math.max(max, list.get(j) + list.get(j - 1));
        }

        return max + activeCnt;
    }
}