public class Solution {
    public boolean isPalindrome(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            head = head.next;
        }
        int i = 0, j = stringBuilder.length() - 1;
        while (i < j) {
            if (stringBuilder.charAt(i) == stringBuilder.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode c1 = new ListNode(8);
        ListNode c2 = new ListNode(1);
        ListNode c3 = new ListNode(4);

        a1.next = a2;
        a2.next = c1;

        c1.next = c2;
        c2.next = c3;
        System.out.println(s.isPalindrome(a1));
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