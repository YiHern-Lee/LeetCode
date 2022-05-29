import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Integer key : map.keySet()) {
            pq.offer(new Integer[] { key, map.get(key) });
        }
        int[] ans = new int[k];
        int idx = 0;
        for (int i = 0; i < k; i++) {
            ans[idx++] = pq.poll()[0];
        }
        return ans;
    }
}