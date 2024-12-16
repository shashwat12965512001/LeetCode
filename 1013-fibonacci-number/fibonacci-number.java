class Solution {
    public static int fibUtil(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = fibUtil(n-1, dp) + fibUtil(n-2, dp);
        return dp[n];
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int dp[] = new int[n+1];
        return fibUtil(n, dp);
    }
}