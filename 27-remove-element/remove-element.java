class Solution {
    public static int removeElement(int[] nums, int val) {
        ArrayList<Integer> li = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                li.add(nums[i]);
            }
        }
        for (int i = 0; i < li.size(); i++) {
            nums[i] = li.get(i);
        }
        return li.size();
    }
}