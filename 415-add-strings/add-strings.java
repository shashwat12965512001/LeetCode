import java.math.BigInteger;

class Solution {
    public static BigInteger strToInt(String str) {
        BigInteger num = BigInteger.ZERO;
        BigInteger pow = BigInteger.ONE;
        BigInteger ten = BigInteger.TEN;
    
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            BigInteger digit = BigInteger.valueOf(ch - '0');
            num = num.add(digit.multiply(pow));
            pow = pow.multiply(ten);
        }
    
        return num;
    }

    public static String addStrings(String num1, String num2) {
        if (num1.length() == 0 && num2.length() == 0) {
            return "";
        } else if (num1.length() == 1 && num2.length() == 1) {
            return String.valueOf((num1.charAt(0) - '0') + (num2.charAt(0) - '0'));
        } else if (num1.length() == 0) {
            return num2;
        } else if (num2.length() == 0) {
            return num1;
        }

        BigInteger first = new BigInteger(num1);
        BigInteger second = new BigInteger(num2);
        BigInteger sum = first.add(second);

        return sum.toString();
    }
}