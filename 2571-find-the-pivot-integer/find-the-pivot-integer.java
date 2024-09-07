class Solution {
    public int pivotInteger(int n) {
        int left = 0;
        int right = n*(n+1)/2;
        for(int k=1;k<=n;k++){
            left += k;
            right -= (k-1);
            if(left == right){
                return k;
            }
        }
        return -1;
    }
}