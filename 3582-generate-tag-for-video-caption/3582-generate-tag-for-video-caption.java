class Solution {
    public String generateTag(String caption) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        String[] arr = caption.trim().split("\\s+");
        
        for(int i = 0 ; i < arr.length ; i++){
            String word = arr[i].replaceAll("[^a-zA-Z]", "").toLowerCase();
            if(word.length() == 0) continue;
            if(i == 0) sb.append(word);
            else{
                sb.append(Character.toUpperCase(word.charAt(0)));
                sb.append(word.substring(1));
            }
        }
        if(sb.length() > 100) return sb.substring(0, 100);

        return sb.toString();
    }
}