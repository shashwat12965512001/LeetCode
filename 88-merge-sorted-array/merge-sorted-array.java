class Solution {
    public static void merge(int[] nums1, int n, int[] nums2, int m) {
        int i, j;
        i = j = 0;
        ArrayList<Integer> li = new ArrayList<>();
        while (i < n && j < m) {
            if (nums1[i] <= nums2[j]) {
                li.add(nums1[i]);
                i++;
            } else {
                li.add(nums2[j]);
                j++;
            }
        }
        while (i < n) {
            li.add(nums1[i]);
            i++;
        }
        while (j < m) {
            li.add(nums2[j]);
            j++;
        }
        for (int k = 0; k < nums1.length; k++) {
            nums1[k] = li.get(k);
        }
    }
}