class Solution {
    public static boolean hasZero(int num) {
        int temp = num;
        while (temp > 0) {
            if ((temp % 10) == 0) {
                return true;
            }
            temp /= 10;
        }
        return false;
    }

    public static boolean isDriven(int num) {
        if (hasZero(num)) {
            return false;
        }
        int temp = num;
        while (temp > 0) {
            if (num % (temp % 10) != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> li = new ArrayList<>();
        if (right <= 9) {
            for (int i = 1; i < right; i++) {
                li.add(i);
            }
            return li;
        }
        for (int i = left; i <= right; i++) {
            if (isDriven(i)) {
                li.add(i);
            }
        }
        return li;
    }
}