class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int rev = 0;
        while (num > 0) {
            rev *= 10;
            rev += num % 10;
            num /= 10;
        }
        System.out.println(rev);
        System.out.println(x);
        return rev == x;
    }
}