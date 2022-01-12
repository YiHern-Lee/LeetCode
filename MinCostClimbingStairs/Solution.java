class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minCostClimbingStairs(new int[] { 1,100,1,1,1,100,1,1,100,1 }));    
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        for (int i = 2; i < cost.length + 1; i++) {
            int minStepCost = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
            dp[i] = minStepCost;
        }
        return dp[cost.length];
    }
}