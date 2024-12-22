class Solution {
    public static int tribonacciUtil(int n, int[] dp) {
        if (n <= 2) {
            return dp[n];
        }
        if (dp[n] == 0) {
            dp[n] += tribonacciUtil(n-1, dp) + tribonacciUtil(n-2, dp) + tribonacciUtil(n-3, dp);
        }
        return dp[n];
    }

    public static int tribonacci(int n) {
        if (n <= 2) {
            return n == 2 ? 1 : n;
        }
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        return tribonacciUtil(n, dp);
    }
}