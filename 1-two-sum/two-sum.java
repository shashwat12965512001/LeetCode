class Solution {
    public static int exists(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                return i;
            }
        }
        return -1;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            int index = exists(nums, diff);
            if (index != -1 && index != i) {
                arr[0] = i;
                arr[1] = index;
                return arr;
            }
        }
        return arr;
    }
}