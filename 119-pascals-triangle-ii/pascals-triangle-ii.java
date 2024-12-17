class Solution {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> li = new ArrayList<>();
        if (rowIndex <= 2) {
            switch (rowIndex) {
                case 0:
                    li.add(1);
                    break;
                case 1:
                    li.add(1);
                    li.add(1);
                    break;
                case 2:
                    li.add(1);
                    li.add(2);
                    li.add(1);
                    break;
            }
            return li;
        }
        List<Integer> last = getRow(rowIndex-1);
        li.add(1);
        for (int i = 1; i < last.size(); i++) {
            li.add(last.get(i-1) + last.get(i));
        }
        li.add(1);
        return li;
    }
}