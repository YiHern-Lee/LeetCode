import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indeg = new int[numCourses];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adjList.add(new ArrayList<>());
        for (int[] prereq : prerequisites) {
            adjList.get(prereq[1]).add(prereq[0]);
            indeg[prereq[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) q.offer(i);
        }
        int[] ans = new int[numCourses];
        int idx = 0;
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            ans[idx++] = curr;
            for (Integer neighbour : adjList.get(curr)) {
                indeg[neighbour] -= 1;
                if (indeg[neighbour] == 0) q.offer(neighbour);
            }
        }
        return idx == numCourses ? ans : new int[] {};
    }
}