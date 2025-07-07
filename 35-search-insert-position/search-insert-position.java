class Solution {
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int n = nums.length;
        int end = n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                if (mid == n - 1) {
                    return mid + 1;
                }
                if (target < nums[mid + 1]) {
                    return mid + 1;
                }
                start = mid + 1;
            } else {
                if (mid == 0) {
                    return mid;
                }
                if (target > nums[mid - 1]) {
                    return mid;
                }
                end = mid - 1;
            }
            System.out.println();
        }
        return -1;
    }
}