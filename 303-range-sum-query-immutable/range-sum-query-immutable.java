class NumArray {
    int[] arr;

    public NumArray(int[] nums) {
        int sum=0;
        int size = nums.length;
        arr = new int[size];
        for(int i = 0; i < size; i++) {
            sum=sum+nums[i];
            arr[i]+=sum;
            // arr[i] = nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
       if(left==0)
       {
            return arr[right];
       }
       else
       {
            return arr[right]-arr[left-1];
       }
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */