class Solution {
    public int reverse(int x) {
        long num = 0;
        while (x != 0) {
            num += x % 10;
            x /= 10;
            if (x == 0) {
                break;
            }
            num *= 10;
        }
        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) num;
    }
}