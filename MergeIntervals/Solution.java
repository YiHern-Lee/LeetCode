import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.merge(new int[][] { {1,100},{2,6},{8,10},{15,18} });
        s.merge(new int[][] { {1,4},{4,5} });
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> y[1] - x[1]);
        boolean[] merged = new boolean[intervals.length];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] >= intervals[i - 1][0]) {
                intervals[i][1] = intervals[i - 1][1];
                intervals[i][0] = Math.min(intervals[i][0], intervals[i - 1][0]);
                merged[i - 1] = true;
            } else count++;
        }
        int[][] ans = new int[count][2];
        int idx = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (!merged[i]) ans[idx++] = intervals[i];
        }
        for (int[] a : ans) {
            System.out.println(Arrays.toString(a));
        }
        return ans;
    }
}