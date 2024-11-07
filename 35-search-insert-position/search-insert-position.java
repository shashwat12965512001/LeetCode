class Solution {
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n-1;

        // Base Cases
        if (target <= nums[start] || n == start) {
            return start;
        }
        if (target > nums[end]) {
            return end+1;
        }
        if (target == nums[end]) {
            return end;
        }
        if (n == 1) {
            if (nums[start] >= target) {
                return start;
            }
            return start+1;
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }else if (target < nums[mid]) {
                if (target > nums[mid-1]) {
                    return mid;
                }
                end = mid;
            }else {
                if (target < nums[mid+1]) {
                    return mid+1;
                }
                start = mid+1;
            }
        }
        return -1;
    }
}