class Solution {
    public static int addDigits(int num) {
        if (num <= 10) {
            return num == 10 ? 1 : num;
        }
        while (num > 10) {
            int temp = num;
            int sum = 0;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (sum == 10) {
                return 1;
            }
            num = sum;
        }
        return num;
    }
}