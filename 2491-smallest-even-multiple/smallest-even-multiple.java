class Solution {
    public static int smallestEvenMultiple(int n) {
        if(n == 1){
            return 2;
        }
        int multiple = 0;
        ArrayList<Integer> table2 = new ArrayList<>();
        ArrayList<Integer> tablen = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            table2.add(2 * (i+1));
            tablen.add(n * (i+1));
        }
        for (int i = 0; i < table2.size(); i++) {
            int ans = table2.get(i);
            if (tablen.indexOf(ans) != -1) {
                multiple = ans;
                break;
            }
        }
        return multiple;
    }
}