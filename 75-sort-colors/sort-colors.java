class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            while (count != 0) {
                nums[index] = key;
                count--;
                index++;
            }
        }
    }
}