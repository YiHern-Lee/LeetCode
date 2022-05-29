class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            boolean matched = false;
            for (int j = 0; j < text2.length(); j++) {
                int up = i > 0 ? dp[i - 1][j] : 0;
                int left = j > 0 ? dp[i][j - 1] : 0;
                int diag = i > 0 && j > 0 ? dp[i - 1][j - 1] : 0;
                dp[i][j] = Math.max(up, left);
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = diag + 1;
                } else {
                    dp[i][j] = Math.max(left, up);
                }
            }
        }
        return dp[text1.length() - 1][text2.length() - 1];
    }
}