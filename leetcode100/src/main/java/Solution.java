import java.util.*;

class Solution {
    // dfs
    // public int maxDepth(TreeNode root) {
    //     if (root == null) return 0;
    //     return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    // }

    // bfs
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        // 用 LinkedList 因为移除头部元素复杂度为O(1) ArrayList 复杂度是O(n)
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                TreeNode treeNode = queue.removeFirst();
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            depth++;
        }
        return depth;
    }


    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);

        a.right = b;
        b.left = c;

        System.out.println(s.maxDepth(a));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
