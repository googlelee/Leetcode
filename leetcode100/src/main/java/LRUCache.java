import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, ListNode> hashMap;
    int capacity;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashMap = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-2, -2, head, null);
        head.next = tail;
    }

    public int get(int key) {
        int val = -1;
        if (hashMap.get(key) != null) {
            val = hashMap.get(key).value;
            moveToHead(key);
        }
        System.out.println(val);
        return val;
    }

    private void moveToHead(int key) {
        ListNode tmp = hashMap.get(key);
        tmp.pre.next = tmp.next;
        tmp.next.pre = tmp.pre;
        tmp.pre = head;
        tmp.next = head.next;
        head.next.pre = tmp;
        head.next = tmp;
        hashMap.put(key, tmp);
    }

    public void put(int key, int value) {
        if (hashMap.get(key) == null) {
            if (this.capacity == 0) {
                hashMap.remove(tail.pre.key);
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                this.capacity++;
            }
            this.capacity--;
            ListNode node = new ListNode(key, value, head.next);
            node.pre = head;
            head.next.pre = node;
            head.next = node;
            hashMap.put(key, node);
        } else {
            hashMap.get(key).value = value; // 边界
            moveToHead(key);
        }

    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(2, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(2);    // 返回 1
        lRUCache.put(1, 1); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.put(4, 1); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
    }
}


class ListNode {
    int key;
    int value;
    ListNode pre;
    ListNode next;

    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public ListNode(int key, int value, ListNode pre, ListNode next) {
        this.key = key;
        this.value = value;
        this.pre = pre;
        this.next = next;
    }

    public ListNode(int key, int value, ListNode next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}