class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int size = 0;
        int left, right, mid;
        for (int i = 0; i < nums.length; i++) {
            left = 0; 
            right = size;
            while (left < right) {
                mid = (left + right) / 2;
                if (dp[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            dp[left] = nums[i];
            if (left == size) size++;
        }
        return size;
    }
}