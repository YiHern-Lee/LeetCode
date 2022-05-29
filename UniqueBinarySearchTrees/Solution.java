import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(1));
        System.out.println(s.numTrees(3));
        System.out.println(s.numTrees(5));
        System.out.println(s.numTrees(6));
        System.out.println(s.numTrees(7));
        System.out.println(s.numTrees(8));
        System.out.println(s.numTrees(9));
        System.out.println(s.numTrees(10));
        System.out.println(s.numTrees(18));
        System.out.println(s.numTrees(19));
    }
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        double j;
        for (int i = 0; i < n; i++) {
            j = i;
            dp[i + 1] = (int) ((((2 * j + 1) * 2) / (j + 2)) * dp[i]);
        }
        return dp[n];
    }
}