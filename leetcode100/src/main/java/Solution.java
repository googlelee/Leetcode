import java.util.*;

class Solution {
    public ListNode swapPairs(ListNode head) {
        List<ListNode> odd = new ArrayList<>();
        List<ListNode> even = new ArrayList<>();
        int cnt = 0;
        while (head != null) {
            if (cnt % 2 == 0) {
                odd.add(head);
            } else {
                even.add(head);
            }
            head = head.next;
            cnt++;
        }
        ListNode p = new ListNode();
        ListNode newHead = p;
        int i = 0, j = 0;
        int s = 0;
        while (s < cnt) {
            if (s % 2 != 0 && i < odd.size()) {
                odd.get(i).next = null;
                p.next = odd.get(i++);
                p = p.next;
            }
            if (s % 2 == 0 && j < even.size()){
                even.get(j).next = null;
                p.next = even.get(j++);
                p = p.next;
            }
            s++;
        }
        while (i < odd.size()) {
            odd.get(i).next = null;
            p.next = odd.get(i++);
        }
        while (j < even.size()) {
            odd.get(j).next = null;
            p.next = even.get(j++);
        }
        return newHead.next;
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

        ListNode head = s.swapPairs(a1);
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