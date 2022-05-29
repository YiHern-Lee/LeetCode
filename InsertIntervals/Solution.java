import java.util.Arrays;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][] { newInterval };
        int totalIntervals = 1;
        int left = 0;
        while (left < intervals.length && newInterval[0] > intervals[left][1]) {
            left++;
            totalIntervals++;
        }
        int right = intervals.length - 1;
        while (right >= 0 && newInterval[1] < intervals[right][0]) {
            right--;
            totalIntervals++;
        }
        int[][] ans = new int[totalIntervals][2];
        int[] mergedInterval;
        if (left >= intervals.length || right < 0) mergedInterval = newInterval;
        else mergedInterval = new int[] { Math.min(newInterval[0], intervals[left][0]),
                Math.max(newInterval[1], intervals[right][1]) };    
        int idx = 0;
        for (int i = 0; i < left; i++) {
            ans[idx++] = intervals[i];
        }
        ans[idx++] = mergedInterval;
        for (int i = right + 1; i < intervals.length; i++) {
            ans[idx++] = intervals[i];
        }
        return ans;
    }
}