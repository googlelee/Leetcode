class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode front = dummy;
        while (head != null) {
            int cnt = k;
            while (cnt > 0) {
                if (tail != null) {
                    tail = tail.next;
                    cnt--;
                } else {
                    front.next = head;
                    return dummy.next;
                }
            }
            if (tail != null) {
                ListNode back = tail.next;

                cnt = k;
                ListNode newHead = null;
                ListNode newTail = head;
                while (cnt > 0) {
                    ListNode temp = head.next;
                    head.next = newHead;
                    newHead = head;
                    head = temp;
                    cnt--;
                }

                front.next = newHead;
                newTail.next = back;

                tail = head;
                front = newTail;
            } else {

                ListNode newhead = null;
                while (head != null) {
                    ListNode temp = head.next;
                    head.next = newhead;
                    newhead = head;
                    head = temp;
                }
                front.next = newhead;
                return dummy.next;
            }
        }


        return dummy.next;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        // d.next = e;

        ListNode res = s.reverseKGroup(a, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}