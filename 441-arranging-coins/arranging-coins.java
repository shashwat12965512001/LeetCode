import java.math.BigInteger;

class Solution {
    public static int arrangeCoins(int n) {
        if (n <= 3) {
            return n == 1 ? 1 : n - 1;
        }

        BigInteger bigN = BigInteger.valueOf(n);
        BigInteger i = BigInteger.ONE;
        BigInteger x = BigInteger.ZERO;
        BigInteger count = BigInteger.ZERO;

        while (x.compareTo(bigN) < 0) {
            x = x.add(i);
            i = i.add(BigInteger.ONE);
            count = count.add(BigInteger.ONE);
        }

        return x.equals(bigN) ? count.intValue() : count.subtract(BigInteger.ONE).intValue();
    }
}