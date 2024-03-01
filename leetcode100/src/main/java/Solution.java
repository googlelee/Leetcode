public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while(a != null || b != null) {
            if(a == b) return a;
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return null;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(6);
        ListNode b3 = new ListNode(1);
        ListNode c1 = new ListNode(8);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);

        a1.next = a2;
        a2.next = c1;

        b1.next = b2;
        b2.next = b3;
        b3.next = c1;

        c1.next = c2;
        c2.next = c3;

        System.out.println(s.getIntersectionNode(a1, b1).val);;
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