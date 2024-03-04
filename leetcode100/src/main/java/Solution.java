import java.util.*;

class Solution {
    // dfs
    // public TreeNode invertTree(TreeNode root) {
    //     if (root == null) return null;
    //     TreeNode temp = root.right;
    //     root.right = root.left;
    //     root.left= temp;
    //     invertTree(root.left);
    //     invertTree(root.right);
    //     return root;
    // }

    // bfs
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode front = queue.removeFirst();
            TreeNode temp = front.left;
            front.left = front.right;
            front.right = temp;
            if (front.left != null) {
                queue.add(front.left);
            }
            if (front.right != null) {
                queue.add(front.right);
            }
        }
        return root;
    }




    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(1);

        a.right = b;
        a.left = c;

        TreeNode root = s.invertTree(a);
        List<Integer> res = new LinkedList<>();
        frontOrder(root, res);
        System.out.println(res);
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
