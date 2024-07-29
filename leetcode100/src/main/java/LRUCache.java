/**
 * 思路：如果没有过期机制 这个题的key和value数都不大 直接数组来做hash表即可
 * 这个题的难点就在于过期机制  而且put和get还得是O(1)
 * 也就是说还是得借助hash表  不然实现不了这个复杂度
 * 过期机制还要保证这个复杂度 只能用链表 单链表不行 因为单链表无法删除尾部节点  所以需要双链表
 *
 * 综上总体思路就是  数组保存key和链表节点  链表实现过期机制
 */

class LRUCache {

    BiListNode[] nodes = new BiListNode[10001];
    int capacity;
    int size;

    BiListNode head = new BiListNode(-1, -1, null, null);
    BiListNode tail = new BiListNode(-1, -1, null, null);


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (size == 0) {
            return -1;
        }
        BiListNode node = nodes[key];
        if (node == null) {
            System.out.println(-1);
            return -1;
        } else {
            System.out.println(node.val);
            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            return node.val;
        }
    }

    public void put(int key, int value) {
        BiListNode node = nodes[key];
        if (node == null) {
            if (size == capacity) {
                nodes[tail.pre.key] = null;
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                size -= 1;
            }

            BiListNode temp = new BiListNode(key, value, head, head.next);
            head.next.pre = temp;
            head.next = temp;
            nodes[key] = temp;
            size += 1;

        } else {
            node.val = value;
            if (!node.pre.equals(head)) {
                node.pre.next = node.next;
                node.next.pre = node.pre;

                node.pre = head;
                node.next = head.next;
                head.next.pre = node;
                head.next = node;
            }
        }
    }
}