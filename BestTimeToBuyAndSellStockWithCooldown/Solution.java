class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[] { 1 }));    
    }

    public int maxProfit(int[] prices) {
        int[] bought = new int[prices.length];
        int[] sold = new int[prices.length];
        int[] resting = new int[prices.length];
        bought[0] = -prices[0];
        resting[0] = 0;
        sold[0] = Integer.MIN_VALUE + prices[0];
        for (int i = 1; i < prices.length; i++) {
            bought[i] = Math.max(bought[i - 1], resting[i - 1] - prices[i]);
            sold[i] = bought[i - 1] + prices[i];
            resting[i] = Math.max(resting[i - 1], sold[i - 1]);
        }
        return Math.max(resting[prices.length - 1], sold[prices.length - 1]);
    }
}