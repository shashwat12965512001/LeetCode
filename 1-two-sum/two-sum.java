class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            int diff = target - nums[i];
            if (map.get(diff) != null && map.get(diff) != i) {
                arr[0] = i;
                arr[1] = map.get(diff);
                return arr;
            }
        }
        return arr;
    }
}