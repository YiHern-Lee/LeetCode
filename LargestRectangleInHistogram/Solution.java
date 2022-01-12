class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestRectangleArea(new int[] { 2,4 }));    
    }

    public int largestRectangleArea(int[] heights) {
        int[] right = new int[heights.length];
        int[] left = new int[heights.length];
        left[0] = -1;
        right[heights.length - 1] = heights.length;
        int i;
        for (i = 0; i < heights.length; i++) {
            int pre = i - 1;
            while (pre >= 0 && heights[pre] >= heights[i])
                pre = left[pre];
            left[i] = pre;
        }
        for (i = heights.length - 1; i >= 0; i--) {
            int nxt = i + 1;
            while (nxt < heights.length && heights[nxt] >= heights[i])
                nxt = right[nxt];
            right[i] = nxt;
        }
        int ans = Integer.MIN_VALUE;
        for (i = 0; i < heights.length; i++) {
            int curr = (right[i] - left[i] - 1) * heights[i];
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}