import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.spiralOrder(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        int[][] moves = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int currMove = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int total = rows * cols;
        int[][] visited = new int[rows][cols];
        visited[0][0] = 1;
        int visits = 1;
        int[] currPos = new int[] { 0, 0 };
        ans.add(matrix[0][0]);
        while (visits < total) {
            int[] next = new int[] { currPos[0] + moves[currMove][0], currPos[1] + moves[currMove][1] };
            while (inbounds(next[0], next[1], rows, cols) && visited[next[0]][next[1]] == 0) {
                ans.add(matrix[next[0]][next[1]]);
                currPos[0] = next[0];
                currPos[1] = next[1];
                visited[currPos[0]][currPos[1]] = 1;
                next[0] += moves[currMove][0];
                next[1] += moves[currMove][1];
                visits++;
            }
            currMove = (currMove + 1) % 4;
        }
        return ans;
    }

    boolean inbounds(int row, int col, int rowMax, int colMax) {
        return row >= 0 && row < rowMax && col >= 0 && col < colMax;
    }
}