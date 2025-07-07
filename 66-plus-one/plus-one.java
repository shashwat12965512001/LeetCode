import java.math.BigInteger;

class Solution {
    public static BigInteger arrToInt(int[] digits) {
        BigInteger num = BigInteger.ZERO;
        for (int digit : digits) {
            num = num.multiply(BigInteger.TEN).add(BigInteger.valueOf(digit));
        }
        return num;
    }

    public static int[] plusOne(int[] digits) {
        BigInteger num = arrToInt(digits);
        ArrayList<BigInteger> li = new ArrayList<>();
        num = num.add(BigInteger.ONE);
        while (!num.equals(BigInteger.ZERO)) {
            li.add(num.mod(BigInteger.TEN));
            num = num.divide(BigInteger.TEN);
        }
        Collections.reverse(li);
        int[] result = new int[li.size()];
        for (int i = 0; i < li.size(); i++) {
            result[i] = li.get(i).intValue();
        }
        return result;
    }
}