class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = null;
        ListNode ptr = null;
        while (list1 != null && list2 != null) {
            ListNode next = null;
            if (list1.val < list2.val) {
                next = list1;
                list1 = list1.next;
            } else {
                next = list2;
                list2 = list2.next;
            }
            if (merged == null) {
                merged = next;
                ptr = next;
            } else {
                ptr.next = next;
                ptr = ptr.next;
            }
        }
        while (list1 != null) {
            if (merged == null) {
                merged = list1;
                ptr = list1;
            } else {
                ptr.next = list1;
                ptr = ptr.next;
            }
            list1 = list1.next;
        }
        while (list2 != null) {
            if (merged == null) {
                merged = list2;
                ptr = list2;
            } else {
                ptr.next = list2;
                ptr = ptr.next;
            }
            list2 = list2.next;
        }
        return merged;
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
