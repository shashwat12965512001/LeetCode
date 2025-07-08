class Solution {
    public static ArrayList<Integer> merge(int[] nums1, int[] nums2) {
        ArrayList<Integer> li = new ArrayList<>();
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
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
        return li;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> li = merge(nums1, nums2);
        int size = li.size();
        if (size % 2 == 0) {
            int i = size / 2;
            int j = i - 1;
            return (((double) li.get(i) + li.get(j)) / 2);
        }
        return (double) (li.get(size / 2));
    }
}