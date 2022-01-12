class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[] { 1,3,2,8,4,9 }, 2));
        System.out.println(s.maxProfit(new int[] { 1,3,7,5,10,3 }, 3));
        System.out.println(s.maxProfit(new int[] { 9,8,7,1,2 }, 3));
        System.out.println(s.maxProfit(new int[] { 2,1,4,4,2,3,2,5,1,2 }, 1));
    }
    public int maxProfit(int[] prices, int fee) {
        int[] holdingStock = new int[prices.length];
        int[] noStock = new int[prices.length];
        holdingStock[0] = -prices[0];
        noStock[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            holdingStock[i] = Math.max(holdingStock[i - 1], noStock[i - 1] - prices[i]);
            noStock[i] = Math.max(noStock[i - 1], holdingStock[i - 1] + prices[i] - fee);
        }
        int ans = Math.max(noStock[prices.length - 1], holdingStock[prices.length - 1]);
        return ans > 0 ? ans : 0;
    }
}