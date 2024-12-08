class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int rev = x;
        int last = 0;
        int num = 0;
        while (rev != 0) {
            last = rev % 10;
            rev = rev/10;
            num = (num * 10) + last;
        }
        return num == x;
    }
}