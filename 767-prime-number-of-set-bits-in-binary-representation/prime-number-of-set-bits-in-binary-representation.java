import java.math.BigInteger;
class Solution {
    public static BigInteger decimalToBinary(int num) {
        BigInteger temp = BigInteger.valueOf(num);
        BigInteger result = BigInteger.ZERO;
        BigInteger pow = BigInteger.ONE;
        BigInteger two = BigInteger.valueOf(2);

        while (temp.compareTo(BigInteger.ZERO) > 0) {
            result = result.add(temp.mod(two).multiply(pow));
            temp = temp.divide(two);
            pow = pow.multiply(BigInteger.TEN);
        }

        return result;
    }

    public static int noOfOnes(BigInteger num) {
        BigInteger temp = num;
        int count = 0;
        BigInteger ten = BigInteger.TEN;
        BigInteger one = BigInteger.ONE;
    
        while (temp.compareTo(BigInteger.ZERO) > 0) {
            if (temp.mod(ten).equals(one)) {
                count++;
            }
            temp = temp.divide(ten);
        }
    
        return count;
    }

    public static boolean isPrime(int num) {
        if (num <= 11) {
            switch (num) {
                case 1:
                    return false;
                case 2:
                    return true;
                case 3:
                    return true;
                case 4:
                    return false;
                case 5:
                    return true;
                case 6:
                    return false;
                case 7:
                    return true;
                case 8:
                    return false;
                case 9:
                    return false;
                case 10:
                    return false;
                case 11:
                    return true;
            }
        }
        for (int i = 2; i < num; i++) {
            if ((num % i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static int countPrimeSetBits(int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isPrime(noOfOnes(decimalToBinary(i)))) {
                count++;
            }
        }
        return count;
    }
}