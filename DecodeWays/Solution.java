import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("11127")); 
        System.out.println(s.numDecodings("11120")); 
        System.out.println(s.numDecodings("11118")); 
        System.out.println(s.numDecodings("06")); 
        System.out.println(s.numDecodings("2101")); 
    }

    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int curr = s.charAt(i - 1) - '0';
            int prev = s.charAt(i - 2) - '0';
            if (curr + prev == 0 || curr == 0 && prev > 2) return 0;
            else if (curr == 0) dp[i] = dp[i - 2];
            else if (prev == 0 || curr + prev * 10 > 26) dp[i] = dp[i - 1];
            else dp[i] = dp[i - 1] + dp[i - 2];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}