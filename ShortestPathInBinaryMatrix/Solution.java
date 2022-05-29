import java.util.PriorityQueue;

class Solution {
    static int[][] MOVES = new int[][] { {0, 1}, {0, -1}, {-1, 1}, {-1, -1}, {-1, 0}, {1, 0}, {1, 1}, {1, -1} }; 
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }

        int[][] shortestPaths = new int[grid.length][grid[0].length];
        int i, j;
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                shortestPaths[i][j] = Integer.MAX_VALUE;
            }
        }
        shortestPaths[0][0] = 1;
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((x, y) -> Integer.compare((int) x[0], (int) y[0]));
        pq.add(new Integer[] {1, 0, 0});

        // int[] { currDist, currX, currY }
        Integer[] currEnt;
        Integer currDist;
        Integer[] currPos;
        Integer[] nextPos;

        Loop:
        while (!pq.isEmpty()) {
            currEnt = pq.poll();
            currDist = currEnt[0];
            currPos = new Integer[] { currEnt[1], currEnt[2] };
            // If current distance is not the shortest
            if (currEnt[0] > shortestPaths[currPos[0]][currPos[1]])
                continue;
            
            for (int[] move : MOVES) {
                nextPos = new Integer[] { currPos[0] + move[0], currPos[1] + move[1] };

                // If next position is not inbounds of matrix or the cell is not a 0
                if (!inbounds(nextPos, grid) || grid[nextPos[0]][nextPos[1]] != 0) 
                    continue;

                // Early termination if end is reached
                if (nextPos[0] == grid.length - 1 && nextPos[1] == grid[0].length) {
                    shortestPaths[grid.length - 1][grid[0].length] = currDist + 1;
                    break Loop;
                }

                Integer nextDist = currDist + 1;
                // Current path is not shorter than a path encountered previously
                if (nextDist >= shortestPaths[nextPos[0]][nextPos[1]])
                    continue;
                
                shortestPaths[nextPos[0]][nextPos[1]] = currDist + 1;
                pq.add(new Integer[] { currDist + 1, nextPos[0], nextPos[1] });
            }
        }

        return shortestPaths[grid.length - 1][grid[0].length - 1] < Integer.MAX_VALUE ? shortestPaths[grid.length - 1][grid[0].length - 1] : -1;
    }

    static boolean inbounds(Integer[] nextMove, int[][] bounds) {
        return 0 <= nextMove[0] && nextMove[0] < bounds.length && 0 <= nextMove[1] && nextMove[1] < bounds[0].length;
    }
}