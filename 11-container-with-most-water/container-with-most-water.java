class Solution {
    public static int maxArea(int[] height) {
        int area = 0;
        int n = height.length;
        int width = n - 1;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int first = height[i];
            int last = height[j];
            if (first < last) {
                area = Math.max(area, first * width);
                i++;
            } else {
                area = Math.max(area, last * width);
                j--;
            }
            width--;
        }
        return area;
    }
}