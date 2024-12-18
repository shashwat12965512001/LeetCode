class Solution {
    public static int isPresent(String s, char ch) {
        return s.indexOf(ch);
    }

    public static boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (n == 0 || m == 0) {
            return n == 0;
        }else if (n == m) {
            return s.equals(t);
        }else if (n <= 2) {
            if (n == 1) {
                return !(t.indexOf(s.charAt(0)) == -1);
            }else {
                char first = s.charAt(0);
                char second = s.charAt(1);
                if (t.indexOf(first) != -1 && t.indexOf(second) != -1) {
                    int index = t.indexOf(first);
                    t = t.substring(index+1);
                    return t.indexOf(second) != -1;
                }
                return false;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int index = isPresent(t, ch);
            if (index != -1) {
                if (index != t.length()-1) {
                    t = t.substring(index+1);
                }else if (i != n-1) {
                    return false;
                }
                count++;
            }
            System.out.println();
        }
        return count == s.length();
    }
}