class Solution {
    public static int maxArea(int[] height) {
		int maxArea = 0;
		int n = height.length;
		int i = 0;
		int j = n-1;
		while (i < j) {
			int ht = Math.min(height[i], height[j]);
			int width = j - i;
			int maxWater = ht * width;
			maxArea = Math.max(maxArea, maxWater);
            if (height[i] < height[j]) {
				i++;
			}else{
				j--;
			}
		}
        return maxArea;
    }
}