import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().productExceptSelf(new int[] { 1,2,3,4 })));
    }
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        int left = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i - 1] * left;
            left = ans[i];
        }
        System.out.println(Arrays.toString(ans));
        int right = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }
        return ans;
    }
}