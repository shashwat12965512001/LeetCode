class Solution {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> prev = new ArrayList<>();
            if (i > 2) {
                prev = result.get(i-2);
            }
            List<Integer> li = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i-1) {
                    li.add(1);
                }
                else if (i > 2) {
                    li.add(prev.get(j-1) + prev.get(j));
                }
            }
            result.add(li);
        }
        return result;
    }
}