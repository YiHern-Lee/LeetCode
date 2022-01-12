class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getMaxLen(new int[] { 1,-2,-3,4 }));
        System.out.println(s.getMaxLen(new int[] { 0,1,-2,-3,-4}));
        System.out.println(s.getMaxLen(new int[] { -1,-2,-3,0,1 }));
        System.out.println(s.getMaxLen(new int[] { 2,-1,3,4,5,2,6,0,-1,-2,-3 }));
        System.out.println(s.getMaxLen(new int[] { 1,2,3,5,-6,4,0,10 }));
        System.out.println(s.getMaxLen(new int[] { 5,-20,-20,-39,-5,0,0,0,36,-32,0,-7,-10,-7,21,20,-12,-34,26,2 }));
    }

    public int getMaxLen(int[] nums) {
        int currPos = 0, currNeg = 0, maxPos = 0, temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                currPos = 0;
                currNeg = 0;
            } else if (nums[i] > 0) {
                if (currNeg > 0) currNeg++;
                currPos++;
            } else {
                temp = currNeg == 0 ? 0 : currNeg + 1;
                currNeg = currPos + 1;
                currPos = temp;
            }
            maxPos = Math.max(maxPos, currPos);
        }
        return maxPos;
    }
}