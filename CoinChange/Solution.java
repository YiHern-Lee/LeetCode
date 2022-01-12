import java.util.PriorityQueue;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] distance = new int[amount + 1];
        for (int i = 1; i < amount + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new Integer[] {0, 0});
        while (!pq.isEmpty()) {
            Integer[] curr = pq.poll();
            if (curr[0] == amount) break;
            for (int coin : coins) {
                if (inbounds(coin + curr[0], amount + 1) && curr[1] + 1 < distance[coin + curr[0]]) {
                    distance[coin + curr[0]] = curr[1] + 1;
                    pq.offer(new Integer[] { coin + curr[0], curr[1] + 1 });
                }
            }
        }
        return distance[amount] < Integer.MAX_VALUE ? distance[amount] : -1;
    }

    static boolean inbounds(int i, int ceil) {
        return i >= 0 && i < ceil;
    }
}