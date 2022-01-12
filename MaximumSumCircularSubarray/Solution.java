class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxSubarraySumCircular(new int[] { 1, -2, 3, -2 }));
        System.out.println(s.maxSubarraySumCircular(new int[] { 5, -3, 5 }));
        System.out.println(s.maxSubarraySumCircular(new int[] { -3, -2, -3 }));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currMax = 0;
        int min = Integer.MAX_VALUE;
        int currMin = 0;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            currMax += nums[i];
            currMin += nums[i];
            max = Math.max(max, currMax);
            min = Math.min(min, currMin);
            if (currMax < 0) currMax = 0;
            if (currMin > 0) currMin = 0;
        }
        return max > 0 ? Math.max(max, total - min) : max;
    }
}