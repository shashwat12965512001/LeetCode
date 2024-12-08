class Solution {
    public static int romanToInt(String s) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // Edge Cases
        if (len == 1) {
            return map.get(s.charAt(0));
        }
        int num = 0;
        for (int i = len-1; i >= 0; i--) {
            char ch = s.charAt(i);
            int val = map.get(ch);
            while (i >= 1 && val <= map.get(s.charAt(i-1))) {
                num += val;
                val = map.get(s.charAt(i-1));
                i--;
            }
            if (i == 0) {
                num += map.get(s.charAt(0));
                return num;
            }
            num += val - map.get(s.charAt(i-1));
            i--;
        }

        return num;
    }
}