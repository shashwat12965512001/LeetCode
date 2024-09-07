class Solution {
    public int pivotInteger(int n) {
        int cummulative_sum = n*(n+1)/2;
        int pivot = (int)Math.sqrt(cummulative_sum);
        return (pivot*pivot == cummulative_sum) ? pivot : -1;
    }
}