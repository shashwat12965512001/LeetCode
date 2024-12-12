class Solution {
    public static boolean checkPerfectNumber(int num) {
        int temp = 1;
        int sum = 0;
        while (temp < num) {
            if (num % temp == 0) {
                sum += temp;
            }
            temp++;
        }
        return sum == num;
    }
}