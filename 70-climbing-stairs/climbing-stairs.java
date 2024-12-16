class Solution {
    public static int climbStairsUtil(int n, int[] dp) {
        if (n <= 3) {
            return n == 0 ? 1 : n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = climbStairsUtil(n-1, dp) + climbStairsUtil(n-2, dp);
        return dp[n];
    }

    public static int climbStairs(int n) {
        if (n <= 3) {
            return n == 0 ? 1 : n;
        }
        int dp[] = new int[n+1];
        return climbStairsUtil(n, dp);
    }
}