import java.math.BigInteger;

class Solution {
    public static BigInteger binaryToDecimal(BigInteger num) {
        BigInteger temp = num;
        BigInteger last;
        BigInteger i = BigInteger.ZERO;
        BigInteger decimal = BigInteger.ZERO;
        BigInteger two = BigInteger.valueOf(2);
        BigInteger ten = BigInteger.valueOf(10);
    
        while (!temp.equals(BigInteger.ZERO)) {
            last = temp.mod(ten); // Get the last digit
            temp = temp.divide(ten); // Remove the last digit
            decimal = decimal.add(last.multiply(two.pow(i.intValue()))); // Add to the decimal value
            i = i.add(BigInteger.ONE); // Increment the power
        }
        return decimal;
    }

    public static BigInteger decimalToBinary(BigInteger num) {
        StringBuilder binary = new StringBuilder();
        BigInteger two = BigInteger.valueOf(2);
    
        while (num.compareTo(BigInteger.ZERO) > 0) {
            binary.append(num.mod(two)); // Append the remainder (0 or 1)
            num = num.divide(two); // Divide the number by 2
        }
    
        // Since the binary digits are collected in reverse order, reverse the string
        return new BigInteger(binary.reverse().toString());
    }    

    public static String addBinary(String a, String b) {
        if (a.equals("0")) {
            return b;
        }else if (b.equals("0")) {
            return a;
        }
        BigInteger num1 = binaryToDecimal(new BigInteger(a));
        BigInteger num2 = binaryToDecimal(new BigInteger(b));
        return String.valueOf(decimalToBinary(num1.add(num2)));
    }
}