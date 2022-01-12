class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[] { 7,1,5,3,6,4 }));
        System.out.println(s.maxProfit(new int[] { 1,2,3,4,5 }));
        System.out.println(s.maxProfit(new int[] { 7,6,4,3,1 }));
        System.out.println(s.maxProfit(new int[] { 7,6,4,8,1 }));
        System.out.println(s.maxProfit(new int[] { 1,2,3,4,5,1 }));
        System.out.println(s.maxProfit(new int[] { 1, 10, 9, 1, 8 }));
        System.out.println(s.maxProfit(new int[] { 3, 2, 5, 8, 1, 9 }));
    }
    public int maxProfit(int[] prices) {
        int prev = prices[0], curr = 0, ans = 0, next;
        for (int i = 1; i < prices.length; i++) {
            next = curr + prices[i] - prev;
            if (curr > next) {
                ans += curr;
                curr = 0;
            } else if (next < 0) curr = 0;
            else curr = next;
            prev = prices[i];
        }
        if (curr > 0) ans += curr;
        return ans;
    }
}