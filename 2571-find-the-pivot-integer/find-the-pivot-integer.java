class Solution {
    public int pivotInteger(int n) {
        // int left = 0;
        // int right = n*(n+1)/2;
        // for(int k=1;k<=n;k++){
        //     left += k;
        //     right -= (k-1);
        //     if(left == right){
        //         return k;
        //     }
        // }
        // return -1;

        int cummulative_sum = n*(n+1)/2;
        int pivot = (int)Math.sqrt(cummulative_sum);
        return (pivot*pivot == cummulative_sum) ? pivot : -1;

    }
}