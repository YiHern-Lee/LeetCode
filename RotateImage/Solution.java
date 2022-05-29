class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.rotate(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            // 1st pos = matrix[i][i] -> matrix[i][j];
            // 2nd pos = matrix[i][n-1] -> matrix[j][n - 1 - i];
            // 3rd pos = matrix[n - 1][n - 1] -> matrix[n - 1 - i][n - 1 - j];
            // 4th pos = matrix[n - 1][i] -> matrix[n - 1 - j][i];
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }
}