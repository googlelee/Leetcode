public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 边界
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode temp = new ListNode();
        ListNode head1 = list1;
        ListNode head2 = list2;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 != null) temp.next = list1;
        if (list2 != null) temp.next = list2;
        return head1.val <= head2.val ? head1 : head2;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);

        ListNode c1 = new ListNode(1);
        ListNode c2 = new ListNode(3);
        ListNode c3 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;

        c1.next = c2;
        c2.next = c3;

        ListNode head = s.mergeTwoLists(a1, c1);
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