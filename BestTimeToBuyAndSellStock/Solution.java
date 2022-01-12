class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[] {7,6,4,3,1}));
        System.out.println(s.maxProfit(new int[] {1}));
    }
    public int maxProfit(int[] prices) {
        int ans = -1, n = prices.length;
        if (n == 1) return 0;
        int highest = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ans = Math.max(ans, highest - prices[i]);
            highest = Math.max(highest, prices[i]);
        }
        return ans > 0 ? ans : 0;
    }
}