class Solution {
    public static int getLowest(String[] strs) {
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            len = Math.min(len, strs[i].length());
        }
        return len;
    }

    public static boolean allSame(String[] strs) {
        for (int i = 0; i < strs.length - 1; i++) {
            if (!strs[i].equals(strs[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = "";
        int n = strs.length;
        int len = getLowest(strs);
        for (int i = 0; i < len; i++) {
            String[] prefixArr = new String[n];
            for (int j = 0; j < n; j++) {
                String single = strs[j];
                prefixArr[j] = String.valueOf(single.charAt(i));
            }
            if (!allSame(prefixArr)) {
                return prefix;
            }
            prefix += prefixArr[0];
        }
        return prefix;
    }
}