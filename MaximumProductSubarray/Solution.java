class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProduct(new int[] { -2, 0, -1 }));    
    }

    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currMax = 1, currMin = 1, temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                temp = currMax;
                currMax = currMin;
                currMin = temp;
            }
            currMax = Math.max(currMax * nums[i], nums[i]);
            currMin = Math.min(currMin * nums[i], nums[i]);
            max = Math.max(max, currMax);
        }
        return max;
    }
}