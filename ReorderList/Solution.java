class ReorderList {
    public void reorderList(ListNode head) {
        // find middle node
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr.next != null && fastPtr.next.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // reverse all nodes after the middle node
        ListNode ptr = slowPtr.next;;
        ListNode prev = null;
        while (ptr != null) {
            ListNode next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }

        slowPtr.next = null;

        ListNode ptr1 = head;
        ListNode ptr2 = prev;
        // merge head and newHead
        while (ptr1 != null && ptr2 != null) {
            ListNode next1 = ptr1.next;
            ptr1.next = ptr2;
            ptr1 = ptr2;
            ptr2 = next1;
            
        }
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
}

class Solution {
    public static void main(String[] args) {
        
    }
}