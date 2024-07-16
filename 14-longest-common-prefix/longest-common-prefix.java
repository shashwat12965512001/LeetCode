class Solution {
    public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) {
			return "";
		}
		HashMap<Integer, String> map = new HashMap<>();
		StringBuilder prefix = new StringBuilder();
		int index = 0;
		int minlen = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			minlen = Math.min(minlen, strs[i].length());
		}
		if (minlen == Integer.MAX_VALUE || minlen == 0) {
			return "";
		}
		map.put(index, String.valueOf(strs[0].charAt(0)));
		while (index < minlen) {
			boolean isbreak = false;
			int count = 0;
			for (int i = 0; i < strs.length; i++) {
				char ch = strs[i].charAt(index);
				String val = map.get(index);
				if (val == null) {
					count++;
					map.put(index, String.valueOf(ch));
				}else if (!val.equals(String.valueOf(ch))) {
					isbreak = true;
					break;
				}else{
					count++;
					map.put(index, String.valueOf(ch));
				}
			}
			if (!isbreak) {
				prefix.append(map.get(index));
			}else if (count == strs.length) {
				prefix.append(map.get(index));
				count = 0;
			}else{
				break;
			}
			if (index == 0 && prefix.toString().isEmpty()) {
				return "";
			}
			index++;
		}
		return prefix.toString();
    }
}