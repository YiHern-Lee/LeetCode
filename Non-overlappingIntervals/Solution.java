import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.eraseOverlapIntervals(new int[][] {{ 1, 100 }, { 11, 22 }, { 1, 11 }, { 2, 12 }}));
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[1] - y[1]);
        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}