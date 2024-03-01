
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode newHead = new ListNode();
        ListNode pre = newHead;
        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            int sum = num1 + num2 + c;
            c = sum / 10;
            int val = sum % 10;
            ListNode newNode = new ListNode(val);
            newHead.next = newNode;
            newHead = newNode;
        }
        if (c != 0) newHead.next = new ListNode(c);
        return pre.next;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(4);
        ListNode a3 = new ListNode(3);
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;

        b1.next = b2;
        b2.next = b3;

        ListNode head = s.addTwoNumbers(a1, b1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
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