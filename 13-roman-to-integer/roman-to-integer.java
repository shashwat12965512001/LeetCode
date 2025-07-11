class Solution {
    public static int getVal(char ch) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map.get(ch);
    }

    public static int baseVal(int val) {
        if (val <= 10) {
            return 10;
        } else if (val <= 100) {
            return 100;
        }
        return 1000;
    }

    public static int convert(String str) {
        int n = str.length();
        int num = 0;
        int last = 0;
        for (int i = n - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            int val = getVal(ch);
            if (last > val) {
                num -= val;
            } else {
                num += val;
            }
            last = val;
        }
        return num;
    }

    public static int romanToInt(String s) {
        int n = s.length();
        int num = 0;
        int i = n - 1;
        while (i >= 0) {
            char ch = s.charAt(i);
            int val = getVal(ch);
            int base = baseVal(val);
            StringBuilder sb = new StringBuilder();
            while (val <= base) {
                sb.append(s.charAt(i));
                i--;
                if (i < 0) {
                    break;
                }
            }
            num += convert(sb.reverse().toString());
        }
        return num;
    }
}