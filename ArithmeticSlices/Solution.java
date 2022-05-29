class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numberOfArithmeticSlices(new int[] { 1, 3, 5, 7, 9 }));
        System.out.println(s.numberOfArithmeticSlices(new int[] { 7,7,7,7 }));
        System.out.println(s.numberOfArithmeticSlices(new int[] { 1,2,4,6,7,8 }));
    }
    public int numberOfArithmeticSlices(int[] nums) {
        int prev = Integer.MIN_VALUE, ans = 0, consec = 0;
        for (int i = 1; i < nums.length; i++) {
            if (prev != nums[i] - nums[i - 1]) {
                consec = 0;
                prev = nums[i] - nums[i - 1];
            } else {
                consec++;
                ans += consec;
            }
        }
        return ans;
    }
}