class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = l1.val, num2 = l2.val;
        int sum = num1 + num2;
        int carry = sum / 10;
        ListNode result = new ListNode(sum % 10);
        ListNode pointer = result;
        l1 = l1.next;
        l2 = l2.next;
        while (l1 != null || l2 != null) {
            num1 = l1 == null ? 0 : l1.val;
            num2 = l2 == null ? 0 : l2.val;
            sum = num1 + num2 + carry;
            pointer.next = new ListNode(sum % 10);
            pointer = pointer.next;
            carry = sum / 10;
            l1 = l1 != null ? l1.next : l1;
            l2 = l2 != null ? l2.next : l2;
        }
        if (carry > 0) pointer.next = new ListNode(carry);
        return result;
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