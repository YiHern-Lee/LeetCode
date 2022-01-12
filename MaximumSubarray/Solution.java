class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxSubArray(new int[] { -2,1,-3,4,-1,2,1,-5,4 }));
        System.out.println(s.maxSubArray(new int[] { 1 }));
        System.out.println(s.maxSubArray(new int[] { 5,4,-1,7,8 }));
        System.out.println(s.maxSubArray(new int[] { -5,-4,-3,-7,-1 }));
    }
    public int maxSubArray(int[] nums) {
        int ptr = 1;
        int ans = nums[0];
        int curr = nums[0];
        while (ptr < nums.length) {
            if (curr < 0) {
                curr = nums[ptr];
            } else curr += nums[ptr];
            ptr++;
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}