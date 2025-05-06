class Solution {
    public int reverse(int x) {
        double answer = 0;
        while (x != 0) {
            answer = (answer * 10) + (x % 10);
            if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) answer;
    }
}