class Solution {
    public static boolean isValid(String s) {
		if (s.length() == 1) {
			return false;
		}
		Stack<Character> st = new Stack<>();
		st.push(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			char ch = s.charAt(i);
			switch (ch) {
				case ')':
					if (st.isEmpty()) {
						return false;
					}else if (st.pop() != '(') {
						return false;
					}
					break;
				case ']':
					if (st.isEmpty()) {
						return false;
					}else if (st.pop() != '[') {
						return false;
					}
					break;
				case '}':
					if (st.isEmpty()) {
						return false;
					}else if (st.pop() != '{') {
						return false;
					}
					break;
				default:
					st.push(ch);
					break;
			}
		}
        return st.isEmpty();
    }
}