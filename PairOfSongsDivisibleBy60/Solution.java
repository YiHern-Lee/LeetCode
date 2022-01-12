class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] dp = new int[60];
        int ans = 0;
        for (int t : time) {
            int curr = t % 60;
            if (dp[(60 - curr) % 60] != 0) ans += dp[(60 - curr) % 60];        
            dp[curr]++;
        }
        return ans;
    }
}
