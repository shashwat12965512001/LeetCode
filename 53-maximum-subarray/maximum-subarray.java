class Solution {
    int getHighestNegative(int[] nums) {
        int high = Integer.MIN_VALUE;
        for (int i : nums) {
            high = Math.max(high, i);
        }
        return high;
    }

    boolean allNegatives(int[] nums) {
        for (int i : nums) {
            if (i >= 0) {
                return false;
            }
        }
        return true;
    }

    public int maxSubArray(int[] nums) {
        if (allNegatives(nums)) {
        return getHighestNegative(nums);
        }
        int maxSum, currSum;
        maxSum = currSum = 0;
        for (int i : nums) {
        currSum = (currSum + i) > 0 ? (currSum + i) : 0;
        maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}