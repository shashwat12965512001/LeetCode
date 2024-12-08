class Solution {
    public static int getNum(int num) {
        int temp = num;
        int last = 0;
        int sqr = 0;
        while (temp != 0) {
            last = temp % 10;
            temp /= 10;
            sqr += last * last;
        }
        return sqr;
    }

    public static boolean isHappy(int n) {
        if (n < 0) {
            return false;
        }else if (n <= 3) {
            return (n == 1) ? true : false;
        }
        int num = n;
        int count = 0;
        while (num != 1) {
            if (count == 9999) {
                return false;
            }
            num = getNum(num);
            count++;
        }
        return true;
    }
}