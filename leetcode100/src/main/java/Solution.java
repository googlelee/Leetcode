public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode c1 = new ListNode(1);
        ListNode c2 = new ListNode(4);
//        ListNode c3 = new ListNode(4);

        a1.next = a2;
        a2.next = c1;

        c1.next = c2;
        c2.next = a2;
        System.out.println(s.hasCycle(a1));
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