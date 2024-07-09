class Solution {
    public static int lengthOfLongestSubstring(String s) {
		ArrayList<String> substring = new ArrayList<>();
		StringBuilder str = new StringBuilder();
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (str.indexOf(String.valueOf(ch)) == -1) {
				str.append(ch);
			}else{
				if (!substring.contains(str.toString())) {
					substring.add(str.toString());
				}
				str.delete(0, str.length());
				index++;
				i = index-1;
			}
		}
		substring.add(str.toString());
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!substring.contains(String.valueOf(ch))) {
				substring.add(String.valueOf(ch));
			}
		}
		System.out.println(substring);
		int max = 0;
		for (int i = 0; i < substring.size(); i++) {
			max = Math.max(max, substring.get(i).length());
		}
		return max;
    }
}