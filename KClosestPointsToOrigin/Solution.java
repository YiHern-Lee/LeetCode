import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public static void main(String[] args) {
        Solution run = new Solution();
        int[][] ans1 = run.kClosest(new int[][] { {1, 3}, {-2, 2} }, 1);
        for (int[] ans : ans1) System.out.print(Arrays.toString(ans));
        System.out.println();
        int[][] ans2 = run.kClosest(new int[][] { {3,3}, {-5,1}, {-2,4} }, 2);
        for (int[] ans : ans2) System.out.print(Arrays.toString(ans));
        System.out.println();
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((x, y) -> Double.compare(x.dist, y.dist));
        for (int[] point : points) {
            pq.offer(new Point(point, euclidDist(point)));
        }
        int[][] ans = new int[k][2];
        int idx = 0;
        for (int i = 0; i < k; i++) {
            ans[idx++] = pq.poll().coords;
        }
        return ans;
    }

    static class Point {
        int[] coords;
        double dist;
        Point (int[] c, double d) {
            coords = c;
            dist = d;
        }
    }

    static double euclidDist(int[] point) {
        return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
}