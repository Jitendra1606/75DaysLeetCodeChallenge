class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> result = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0 ; i < tiles.length() ; i++){
            char ch = tiles.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        solve(new StringBuilder(), map, result);
        return result.size();
    }

    public void solve(StringBuilder sb, Map<Character, Integer> map, Set<String> list){
        if(sb.length() > 0){ //we can have string of any length 
            list.add(sb.toString());
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            char num = entry.getKey();
            int cnt = entry.getValue();

            if(cnt == 0) continue;

            sb.append(num);
            map.put(num, cnt - 1);

            solve(sb, map, list);

            sb.deleteCharAt(sb.length() - 1);
            map.put(num, cnt);
        }
    }
}