class Solution {
    public static List<Integer> baseCase(int numRows) {
        List<Integer> li = new ArrayList<>();
        switch (numRows) {
            case 0:
                break;
            case 1:
                li.add(1);
                break;
            case 2:
                li.add(1);
                li.add(1);
                break;
            case 3:
                li.add(1);
                li.add(2);
                li.add(1);
                break;
        }
        return li;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        if (numRows <= 3) {
            switch (numRows) {
                case 0:
                    break;
                case 1:
                    list.add(baseCase(1));
                    break;
                case 2:
                    list.add(baseCase(1));
                    list.add(baseCase(2));
                    break;
                case 3:
                    list.add(baseCase(1));
                    list.add(baseCase(2));
                    list.add(baseCase(3));
                    break;
            }
            return list;
        }
        List<List<Integer>> last = generate(numRows-1);
        li.add(1);
        System.out.println(last.size());
        List<Integer> l = last.get(last.size()-1);
        for (int i = 1; i < l.size(); i++) {
            li.add(l.get(i-1) + l.get(i));
        }
        li.add(1);
        last.add(li);
        return last;
    }
}