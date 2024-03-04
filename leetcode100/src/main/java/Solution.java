import java.lang.management.BufferPoolMXBean;
import java.util.*;

class Solution {
    // dfs
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        return isSymmetricBoth(root.left, root.right);
    }

    private boolean isSymmetricBoth(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isSymmetricBoth(left.left, right.right) && isSymmetricBoth(left.right, right.left);
    }

    // bfs
    // public boolean isSymmetric(TreeNode root) {
    //     if (root.left == null && root.right == null) return true;
    //     List<TreeNode> queue = new LinkedList<>();
    //     queue.add(root.left);
    //     queue.add(root.right);
    //     while (!queue.isEmpty()) {
    //         TreeNode left = queue.removeFirst();
    //         TreeNode right = queue.removeFirst();
    //         if (left == null && right == null) continue;
    //         if (left == null || right == null) return false;
    //         if (left.val != right.val) return false;
    //         queue.add(left.left);
    //         queue.add(right.right);
    //         queue.add(left.right);
    //         queue.add(right.left);
    //     }
    //     return true;
    // }


    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(2);
        TreeNode d = new TreeNode(2);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(3);


        a.left = b;
        a.right = c;
        b.left = d;
        // b.right = e;
        c.left = e;
        // c.right = g;

        // TreeNode root = s.invertTree(a);
        // List<Integer> res = new LinkedList<>();
        // frontOrder(root, res);
        System.out.println(s.isSymmetric(a));
    }

    private static void frontOrder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        frontOrder(root.left, res);
        frontOrder(root.right, res);
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
