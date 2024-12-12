class Solution {
    public static String convertToBase7(int num) {
        int temp = num;
        boolean isNegative = false;
        if (num < 0) {
            temp = Math.abs(num);
            isNegative = true;
        }
        int result = 0;
        int pow = 1;
        while (temp > 0) {
            result += (temp%7) * pow;
            pow *= 10;
            temp /= 7;
        }
        return isNegative ? String.valueOf("-" + String.valueOf(result)) : String.valueOf(result);
    }
}