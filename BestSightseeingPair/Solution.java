class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxScoreSightseeingPair(new int[] { 6,9,10,5,9,10,4,5 }));
        System.out.println(s.maxScoreSightseeingPair(new int[] { 1000,9,10,5,9,10,4,18 }));
    }

    public int maxScoreSightseeingPair(int[] values) {
        int prev = values[0], maxCurr, ans = Integer.MIN_VALUE;
        for (int i = 1; i < values.length; i++) {
            prev--;
            maxCurr = prev + values[i];
            ans = Math.max(maxCurr, ans);
            prev = Math.max(prev, values[i]);
        }
        return ans;
    }
}