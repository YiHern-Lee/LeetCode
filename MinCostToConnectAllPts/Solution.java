import java.util.ArrayList;

class MST {
    public int minCostConnectPoints(int[][] points) {
        ArrayList<Integer[]> edgelist = new ArrayList<>();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                edgelist.add(new Integer[] { i, j, manhattanDist(points[i], points[j]) });
            }
        }
        edgelist.sort((x, y) -> x[2] - y[2]);
        UnionFind mstSets = new UnionFind(points.length);
        int totalCost = 0;
        for (Integer[] edge : edgelist) {
            if (!mstSets.isSameSet(edge[0], edge[1])) {
                mstSets.unionSet(edge[0], edge[1]);
                totalCost += edge[2];
            }
        }

        return totalCost;
    }

    int manhattanDist(int[] pt1, int[] pt2) {
        return Math.abs(pt1[0] - pt2[0]) + Math.abs(pt1[1] - pt2[1]);
    }

    static class UnionFind {
        public int[] p;
        public int[] rank;
        public int[] size;
        public int[] capacity;

        public UnionFind(int N) {
            p = new int[N];
            rank = new int[N];
            size = new int[N];
            capacity = new int[N];
            for (int i = 0; i < N; i++) {
                p[i] = i;
                rank[i] = 0;
                capacity[i] = 1;
            }
        }

        public int findSet(int i) {
            if (p[i] == i)
                return i;
            else {
                p[i] = findSet(p[i]);
                return p[i];
            }
        }

        public Boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public void unionSet(int i, int j) {
            if (!isSameSet(i, j)) {
                int x = findSet(i), y = findSet(j);
                // rank is used to keep the tree short
                if (rank[x] > rank[y]) {
                    p[y] = x;
                    capacity[x] += capacity[y];
                    size[x] += size[y];
                } else {
                    p[x] = y;
                    if (rank[x] == rank[y])
                        rank[y] = rank[y] + 1;
                    capacity[y] += capacity[x];
                    size[y] += size[x];
                }
            }
        }

        public boolean add(int i) {
            int x = findSet(i);
            if (capacity[x] > size[x]) {
                size[x] += 1;
                return true;
            } else 
                return false;
        }
    }
}