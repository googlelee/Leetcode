public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode newHead = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }
        return newHead;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode c1 = new ListNode(8);
        ListNode c2 = new ListNode(4);
        ListNode c3 = new ListNode(5);

        a1.next = a2;
        a2.next = c1;

        c1.next = c2;
        c2.next = c3;
        ListNode h = s.reverseList(a1);
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
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