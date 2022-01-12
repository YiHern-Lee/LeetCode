class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rob(new int[] { 1,2,3,1 }));
        System.out.println(s.rob(new int[]{200,3,140,20,10}));
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(auxRob(nums, 0, n - 2), auxRob(nums, 1, n - 1));
    }
    public static int auxRob(int[] nums, int start, int end) {
        int n = start - end;
        if (n == 0) return nums[start];
        if (n == 1) return Math.max(nums[start], nums[end]);
        int dp0 = nums[start];
        int dp1 = Math.max(nums[start], nums[start + 1]);
        int dp = dp1;
        for (int i = start + 2; i <= end; i++) {
            dp = Math.max(nums[i] + dp0, dp1);
            dp0 = dp1;
            dp1 = dp;
        }
        return dp1;
    }
}