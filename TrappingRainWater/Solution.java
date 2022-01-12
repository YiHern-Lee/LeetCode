class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length]; 
        int[] maxRight = new int[height.length];
        int currMaxLeft = 0;
        for (int i = 0; i < height.length; i++) {
            maxLeft[i] = currMaxLeft;
            if (height[i] > currMaxLeft) currMaxLeft = height[i];
        }
        int currMaxRight = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            maxRight[i] = currMaxRight;
            if (height[i] > currMaxRight) currMaxRight = height[i];
        }
        int water = 0;
        for (int i = 0; i < height.length - 1; i++) {
            water += Math.max(Math.min(maxLeft[i], maxRight[i]) - height[i], 0);
        }
        return water;
    }
}