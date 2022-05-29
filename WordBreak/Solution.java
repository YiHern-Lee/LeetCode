import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        /* System.out.println(s.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(s.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", 
                Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"))); */
        System.out.println(s.wordBreak("abcd", Arrays.asList("a", "abc", "b", "cd")));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (i + word.length() <= n && s.substring(i, i + word.length()).equals(word)) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i]) break;
            }
        }
        return dp[0];
    }
}