import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode pre = new ListNode(-1);
        ListNode p = pre;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (int i = 0; i < lists.length; i++) {
            ListNode tmp = lists[i];
            while (tmp != null) {
                queue.add(new ListNode(tmp.val)); // 不能直接加入tmp，会成环
                tmp = tmp.next;
            }
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
        }

        return pre.next;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode a = new ListNode(-2);
        ListNode b = new ListNode(-1);
        ListNode c = new ListNode(-1);
        ListNode d = new ListNode(-1);

        ListNode e = null;


        a.next = b;
        b.next = c;
        c.next = d;


        ListNode[] lists = {a, e};

        System.out.println(s.mergeKLists(lists));
    }
}
