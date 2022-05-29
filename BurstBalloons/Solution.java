class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] coins = new int[n + 2];
        // actual coins are from index 1 to n
        coins[0] = 1;
        coins[n + 1] = 1;
        
        for (int i = 1; i < n + 1; i++) {
            coins[i] = nums[i - 1];
        }
        
        // First and last row/column left blank 
        int[][] dp = new int[n + 2][n + 2];

        int left, right, curr;
        // i is left boundary and j is right boundary
        for (int i = n; i > 0; i--) {
            for (int j = i; j < n + 1; j++) {
                for (int k = i; k <= j; k++) {
                    left = k == i ? 0 : dp[i][k - 1];
                    right = k == j ? 0 : dp[k + 1][j];
                    curr = coins[k] * coins[i - 1] * coins[j + 1] + left + right;
                    dp[i][j] = Math.max(dp[i][j], curr);
                }
            }
        }
        return dp[1][n];
    }
}