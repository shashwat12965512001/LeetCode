class Solution {
    public static int indexOf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            int index = indexOf(nums, val);
            if (index != -1 && index != i) {
                arr[0] = i;
                arr[1] = index;
                return arr;
            }
        }
        return arr;
    }
}