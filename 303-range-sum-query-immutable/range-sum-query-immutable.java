class NumArray {
    int[] arr;

    public NumArray(int[] nums) {
        int size = nums.length;
        arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        int sum = 0;
        while (left <= right) {
            sum += arr[left];
            left++;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */