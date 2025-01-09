class Solution {
    public static int prefixCount(String[] words, String pref) {
        int n = pref.length();
        int count = 0;
        for (String word : words) {
            if (n <= word.length() && pref.equals(word.substring(0, n)) || pref.equals(word)) {
                count++;
            }
        }
        return count;
    }
}