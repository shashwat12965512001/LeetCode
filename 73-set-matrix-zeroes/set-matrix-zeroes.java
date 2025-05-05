class Solution {
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    pairs.add(new Pair(i, j));
                }
            }
        }
        for (int i = 0; i < pairs.size(); i++) {
            int row = pairs.get(i).row;
            int column = pairs.get(i).column;
            for (int j = 0; j < n; j++) {
                matrix[j][column] = 0;
            }
            for (int j = 0; j < m; j++) {
                matrix[row][j] = 0;
            }
        }
    }
}

class Pair {
    int row;
    int column;

    Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return "(" + row + ", " + column + ")";
    }
}