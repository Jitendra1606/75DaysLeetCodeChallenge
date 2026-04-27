class Solution {
    public boolean hasMatch(String s, String p) {
        int star = p.indexOf('*');
        String prefix = p.substring(0, star);
        String suffix = p.substring(star + 1);

        int start = s.indexOf(prefix);
        if(start == -1) return false;

        // search for suffix after prefix
        int end = s.indexOf(suffix, start + prefix.length()); 
        if(end == -1) return false;
        return true;
    }
}

