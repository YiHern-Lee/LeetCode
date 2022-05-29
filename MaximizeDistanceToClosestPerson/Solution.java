class Solution {
    public int maxDistToClosest(int[] seats) {
        int[] left = new int[seats.length];
        int[] right = new int[seats.length];
        int[] minDist = new int[seats.length];
        int dist = Integer.MAX_VALUE;
        boolean person = false;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                dist = 0;
                person = true;
            } else if (person) {
                dist++;
            }
            left[i] = dist;
        }
        dist = Integer.MAX_VALUE;
        person = false;
        for (int i = seats.length - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                dist = 0;
                person = true;
            } else if (person) {
                dist++;
            }
            right[i] = dist;
        }
        for (int i = 0; i < seats.length; i++) minDist[i] = Math.min(left[i], right[i]);
        int ans = 0;
        for (int i = 0; i < seats.length; i++) {
            if (minDist[i] > ans) ans = minDist[i];
        }
        return ans;
    } 
}