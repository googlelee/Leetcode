import java.lang.runtime.TemplateRuntime;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> hashMap = new HashMap<>();
        Node tmp = head;
        while (tmp != null) {
            hashMap.put(tmp, new Node(tmp.val));
            tmp = tmp.next;
        }
        tmp = head;
        while (tmp != null) {
            hashMap.get(tmp).next = hashMap.get(tmp.next);
            if (tmp.random != null) {
                hashMap.get(tmp).random = hashMap.get(tmp.random);
            }
            tmp = tmp.next;
        }
        return hashMap.get(head);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.copyRandomList(3));
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}