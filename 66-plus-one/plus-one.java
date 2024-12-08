class Solution {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;

        // Edge cases
        if (n == 1) {
            switch (digits[0]) {
                case 0:
                    digits[0] = 1;
                    return digits;
                case 1:
                    digits[0] = 2;
                    return digits;
                case 2:
                    digits[0] = 3;
                    return digits;
                case 3:
                    digits[0] = 4;
                    return digits;
                case 4:
                    digits[0] = 5;
                    return digits;
                case 5:
                    digits[0] = 6;
                    return digits;
                case 6:
                    digits[0] = 7;
                    return digits;
                case 7:
                    digits[0] = 8;
                    return digits;
                case 8:
                    digits[0] = 9;
                    return digits;
                case 9:
                    int arr[] = new int[2];
                    arr[0] = 1;
                    arr[1] = 0;
                    return arr;
            }
        }
        

        boolean all9 = true;
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] != 9) {
                all9 = false;
            }
        }
        if (all9) {
            int arr[] = new int[n+1];
            arr[0] = 1;
            return arr;
        }
        
        int i = n-1;
        int last = digits[i];
        while (i > 0 && last == 9) {
            digits[i] = 0;
            i--;
            last = digits[i];
        }
        if (i >= 0 && i <= n-1) {
            digits[i] += 1;
        }
        return digits;
    }
}