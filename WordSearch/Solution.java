class Solution {
    static int[][] MOVES = new int[][] {{0,1},{1,0},{-1,0},{0,-1}};
    static int MAX_ROW = 0;
    static int MAX_COL = 0;
    static String WORD_FIND = "";
    public boolean exist(char[][] board, String word) {
        MAX_ROW = board.length;
        MAX_COL = board[0].length;
        WORD_FIND = word;
        for (int i = 0; i < MAX_ROW; i++) {
            for (int j = 0; j < MAX_COL; j++) {
                if (board[i][j] == word.charAt(0)) 
                    if (dfs(board, new int[] {i, j}, new int[MAX_ROW][MAX_COL], 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int[] curr, int[][] visited, int idx) {
        if (idx == WORD_FIND.length() - 1) return true;
        visited[curr[0]][curr[1]] = 1;
        for (int[] move : MOVES) {
            int[] next = new int[] {curr[0] + move[0], curr[1] + move[1]};
            if (inbounds(next[0], next[1], MAX_ROW, MAX_COL) && visited[next[0]][next[1]] == 0 
                    && board[next[0]][next[1]] == WORD_FIND.charAt(idx + 1)) {
                if (dfs(board, next, visited, idx + 1)) return true;
            }
        }
        visited[curr[0]][curr[1]] = 0;
        return false;
    }

    boolean inbounds(int row, int col, int maxRow, int maxCol) {
        return row >= 0 && row < maxRow && col >= 0 && col < maxCol;
    }
}