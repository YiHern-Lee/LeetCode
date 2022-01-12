import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> minHeightRoots = new LinkedList<>();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        int[] indegrees = new int[n];
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            indegrees[edge[0]]++;
            indegrees[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 1) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int currSize = q.size();
            minHeightRoots = new LinkedList<>();
            for (int i = 0; i < currSize; i++) {
                Integer curr = q.poll();
                minHeightRoots.add(curr);
                for (Integer neighbour : adjList.get(curr)) {
                    indegrees[neighbour] -= 1;
                    if (indegrees[neighbour] == 1) {
                        q.offer(neighbour);
                    }
                }
            }
        }  
        if (minHeightRoots.size() == 0) minHeightRoots.add(0);
        return minHeightRoots;
    }
}
