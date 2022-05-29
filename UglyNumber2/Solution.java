import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.nthUglyNumber(1));
        System.out.println(s.nthUglyNumber(7));
        System.out.println(s.nthUglyNumber(8));
        System.out.println(s.nthUglyNumber(9));
        System.out.println(s.nthUglyNumber(10));
        System.out.println(s.nthUglyNumber(11));
        System.out.println(s.nthUglyNumber(12));
    }
    public int nthUglyNumber(int n) {
        int p0 = 0, p1 = 0, p2 = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[p0] * 2, Math.min(dp[p1] * 3, dp[p2] * 5));
            if (dp[p0] * 2 == dp[i]) p0++;
            if (dp[p1] * 3 == dp[i]) p1++;
            if (dp[p2] * 5 == dp[i]) p2++;
        }
        return dp[n - 1];
    }
}