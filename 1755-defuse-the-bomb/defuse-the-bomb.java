class Solution {
    public static int[] decrypt(int[] code, int k) {
        int result[] = new int[code.length];
        if (k == 0) {
            for (int i = 0; i < code.length; i++) {
                code[i] = 0;
            }
        }else if (k > 0) {
            for (int i = 0; i < code.length; i++) {
                int val = 0;
                for (int j = 0, x = i+1; j < k; j++, x++) {
                    if (x == code.length) {
                        x = x % code.length;
                    }
                    val += code[x];
                }
                result[i] = val;
            }
        }else {
            k = Math.abs(k);
            for (int i = code.length-1; i >= 0; i--) {
                int val = 0;
                for (int j = 0, x = i-1; j < k; j++, x--) {
                    if (x == 0) {
                        val += code[x];
                        x = code.length;
                        continue;
                    }else if (x < 0) {
                        x = code.length-1;
                        val += code[x];
                        continue;
                    }
                    val += code[x];
                }
                result[i] = val;
            }
        }
        return result;
    }
}