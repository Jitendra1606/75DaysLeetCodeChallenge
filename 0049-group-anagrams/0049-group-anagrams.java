class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs.length == 0 || strs == null) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0 ; i < strs.length ; i++){
            String word = strs[i];//looping through each word
            char[] ch = word.toCharArray();//convert word to char array
            Arrays.sort(ch);//sorting array
            String key = new String(ch);//make sortde array as a key
            if(!map.containsKey(key)){//if key not present
                map.put(key,new ArrayList<>());//create new list
            }       
            map.get(key).add(word);//add original word to it's group
        }
        //convert map values to List<List<String>>
        return new ArrayList<>(map.values());
    }
}