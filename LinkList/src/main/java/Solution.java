public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode oldHead = head;
        ListNode pre = null;  // 保存翻转部分前一个节点
        int newLeft = left;
        while (newLeft > 1) {
            pre = head;
            head = head.next;
            newLeft--;
        }

        ListNode reverseTail = head;

        ListNode newHead = null;
        int len = right - left + 1;
        while (len != 0) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
            len--;
        }

        if (reverseTail != null) {
            reverseTail.next = head;
        }
        if (pre != null) {
            pre.next = newHead;
        } else {
            pre = newHead;
        }

        if (left > 1) return oldHead; // pre已经不是头的场景
        return pre;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);

        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);


        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;


        ListNode head = s.reverseBetween(a1, 3, 4);
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