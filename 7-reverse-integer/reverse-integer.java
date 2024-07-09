import java.math.BigInteger;
class Solution {
    public static int reverse(int x) {
        boolean isnegative = x < 0;
        if (Math.abs(x) >= 2147483647 || Math.abs(x) <= -2147483648) {
            return 0;
        }
        x = Math.abs(x);
        StringBuilder str = new StringBuilder(String.valueOf(x));
        str.reverse();
        BigInteger result = new BigInteger(str.toString());
        BigInteger test = new BigInteger("2147483647");
        if (result.compareTo(test) == 0 || result.compareTo(test) == 1) {
            return 0;
        }
        return isnegative ? -Integer.valueOf(str.toString()) : Integer.valueOf(str.toString());
    }
}