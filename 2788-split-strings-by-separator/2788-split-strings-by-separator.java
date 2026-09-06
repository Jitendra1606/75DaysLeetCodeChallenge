class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {

        List<String> list = new ArrayList<>();

        for (String s : words) {

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < s.length(); j++) {

                if (s.charAt(j) == separator) {

                    if (sb.length() > 0) {
                        list.add(sb.toString());
                        sb.setLength(0);
                    }

                } else {
                    sb.append(s.charAt(j));
                }
            }

            // Add the last word
            if (sb.length() > 0) {
                list.add(sb.toString());
            }
        }

        return list;
    }
}