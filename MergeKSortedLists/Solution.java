import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer[]> minHeap = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.offer(new Integer[] { i, lists[i].val });
                lists[i] = lists[i].next;
            }
        }
        ListNode ans = null;
        ListNode tail = null;
        while (!minHeap.isEmpty()) {
            Integer[] curr = minHeap.poll();
            if (ans == null) {
                ans = new ListNode(curr[1]);
                tail = ans;
            } else {
                tail.next = new ListNode(curr[1]);
                tail = tail.next;
            }
            if (lists[curr[0]] != null) {
                minHeap.offer(new Integer[] { curr[0], lists[curr[0]].val });
                lists[curr[0]] = lists[curr[0]].next;
            }
        }

        return ans;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        if (next == null) {
            return "" + val;
        }
        return val + next.toString();
    }
}