class Solution {
    public boolean judgeCircle(String moves) {
     Map<Character,Integer> map=new HashMap<>();
   for(char c:moves.toCharArray()){
    map.put(c,map.getOrDefault(c,0)+1);
   }
   int up = map.getOrDefault('U', 0);
        int down = map.getOrDefault('D', 0);
        int left = map.getOrDefault('L', 0);
        int right = map.getOrDefault('R', 0);

        return up==down&&left==right;

    }
}