class Solution {
    public static int missingNumber(int[] nums) {
        int len = nums.length;
        boolean arr[] = new boolean[len+1];
        for (int i = 0; i < len; i++) {
            arr[nums[i]] = true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i]) {
                return i;
            }
        }
        return -1;
    }
}