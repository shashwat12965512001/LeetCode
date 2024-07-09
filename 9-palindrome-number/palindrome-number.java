import java.math.BigInteger;
class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x % 10;
        int reminder = x / 10;
        int result = temp;
        while (reminder != 0) {
            temp = reminder % 10;
            reminder = reminder / 10;
            result = (result * 10) + temp;
        }
        return result == x;
    }
}