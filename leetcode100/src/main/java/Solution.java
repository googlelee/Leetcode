import java.util.HashMap;
import java.util.Map;

class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode pre = new ListNode(-1);
        ListNode p = pre;
        Map<Integer, ListNode> hashMap = new HashMap<>();
        for (int i = 0; i < lists.length; i++) {
            hashMap.put(i, lists[i]);
        }

        while (!hashMap.isEmpty()) {
            int min = 10001;
            ListNode minNode = null;
            int pos = -1;
            for (int i = 0; i < hashMap.size(); i++) {
                ListNode tmp = hashMap.get(i);
                if (tmp == null) {
                    continue;
                }
                if (tmp.val < min) {
                    min = tmp.val;
                    minNode = tmp;
                    pos = i;
                }
            }
            if (minNode != null) {
                p.next = minNode;
                p = p.next;
                if (p == null) {
                    hashMap.remove(pos);
                } else {
                    hashMap.put(pos, minNode.next);
                }
            }
            if (hashMap.values().stream().allMatch(x -> x == null)) {
                break;
            }
        }
        return pre.next;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(5);

        ListNode d = new ListNode(1);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(4);

        ListNode g = new ListNode(2);
        ListNode h = new ListNode(6);

        a.next = b;
        b.next = c;

        d.next = e;
        e.next = f;

        g.next = h;

        ListNode[] lists = {a, d, g};

        System.out.println(s.mergeKLists(lists));
    }
}
