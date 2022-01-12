public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.jump(new int[] { 1 }));
        System.out.println(s.jump(new int[] { 2,3,1,1,4 }));
        System.out.println(s.jump(new int[] { 
            7,0,9,6,9,6,1,7,9,0,1,2,9,0,3 }));
    }
    public int jump(int[] nums) {
        int nJumps = 0;
        int maxIdx = 0;
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxIdx >= nums.length - 1) break;
            maxJump = Math.max(maxJump, i + nums[i]);
            if (i == maxIdx) {
                maxIdx = maxJump;
                nJumps++;
            }
        }
        return nJumps;
    }
}
