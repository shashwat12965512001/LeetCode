class Solution {
    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> li = new ArrayList<>();
        int n = words.length;
        if (n <= 2) {
            li.add(words[0]);
            if (n == 2 && groups[0] != groups[1]) {
                li.add(words[1]);
            }
            return li;
        }
        for (int i = 0; i < n-1; i++) {
            if (groups[i] != groups[i+1]) {
                li.add(words[i]);
            }
        }
        li.add(words[n-1]);
        return li;
    }
}