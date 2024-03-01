public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode a = list1;
        ListNode b = list2;
        ListNode p = new ListNode();
        while (a != null && b != null) {
            if (a.val >= b.val) {
                p.next = b;
                b = b.next;
            } else {
                p.next = a;
                a = a.next;
            }
            p = p.next;
        }
        if (a != null) p.next = a;
        if (b != null) p.next = b;

        return list1.val >= list2.val ? list2 : list1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);


        a1.next = a2;
        a2.next = a3;

        b1.next = b2;
        b2.next = b3;


        ListNode head = s.mergeTwoLists(a1, b1);
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