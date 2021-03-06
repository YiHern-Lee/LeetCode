class Solution {
    public int maxArea(int[] height) {
        int first = 0;
        int last = height.length - 1;
        int area = 0;
        while (first < last) {
            int currArea = Math.min(height[first], height[last]) * (last - first);
            if (currArea > area) {
                area = currArea;
            }
            if (height[first] < height[last]) first++;
            else last--;
        }
        return area;
    }
}