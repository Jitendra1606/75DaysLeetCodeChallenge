class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();

        for(int i = 0 ; i < knowledge.size() ; i++){
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            
            if(s.charAt(i) == '('){
                
                int j = i + 1;

                while(s.charAt(j) != ')'){
                    j++;
                }

                String t = s.substring(i + 1, j);

                if(map.containsKey(t)){
                    sb.append(map.get(t));
                }
                else{
                    sb.append("?");
                }
                
                i = j;

            }else{
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}