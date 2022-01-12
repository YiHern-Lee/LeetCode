class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().deleteAndEarn(new int[] {3, 1}));
    }
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int m = Integer.MIN_VALUE;
        for (int num : nums) {
            m = Math.max(num, m);
        }
        int[] sum = new int[m + 1];
        int[] dp = new int[m + 1];
        for (int num : nums) {
            sum[num] += num;
        }
        dp[0] = sum[0];
        dp[1] = Math.max(sum[0], sum[1]);
        for (int i = 2; i < m + 1; i++) {
            dp[i] = Math.max(sum[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[m];
    }
}