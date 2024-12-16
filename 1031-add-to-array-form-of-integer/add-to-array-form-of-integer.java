import java.math.BigInteger;

class Solution {
    public static List<Integer> addToArrayForm(int[] num, int k) {
    List<Integer> li = new ArrayList<>();
    int n = num.length;

    BigInteger val = BigInteger.ZERO;
    BigInteger pow = BigInteger.ONE;

    for (int i = n - 1; i >= 0; i--) {
        val = val.add(pow.multiply(BigInteger.valueOf(num[i])));
        pow = pow.multiply(BigInteger.TEN);
    }

    val = val.add(BigInteger.valueOf(k));

    while (val.compareTo(BigInteger.ZERO) > 0) {
        li.add(val.mod(BigInteger.TEN).intValue());
        val = val.divide(BigInteger.TEN);
    }

    Collections.reverse(li);
    return li;
}
}