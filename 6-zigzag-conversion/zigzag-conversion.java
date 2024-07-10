class Solution {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
			return s;
		}else if (s.length() <= 2) {
			return s;
		}
		@SuppressWarnings("unchecked")
		ArrayList<String>[] str = new ArrayList[numRows];
		for (int i = 0; i < str.length; i++) {
			str[i] = new ArrayList<>();
		}
		int i = 0;
		int index = 0;
		while (i < s.length()) {
			if (index == numRows) {
				index -= 2;
				while (index >= 0 && i < s.length()) {
					char ch = s.charAt(i);
					str[index].add(String.valueOf(ch));
					index--;
					i++;
				}
				index++;
			}else if (index == 0) {
				if (i > 0) {
					index++;
				}
				while (index < numRows && i < s.length()) {
					char ch = s.charAt(i);
					str[index].add(String.valueOf(ch));
					index++;
					i++;
				}
			}
		}
		StringBuilder result = new StringBuilder();
		for (int j = 0; j < str.length; j++) {
			for (int k = 0; k < str[j].size(); k++) {
				result.append(str[j].get(k));
			}
		}
		return result.toString();
    }
}