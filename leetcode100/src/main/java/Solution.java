import java.util.*;

class Solution {
    // bfs
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     if (root == null) return res;
    //     List<TreeNode> queue = new LinkedList<>();
    //     queue.add(root);
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         while (size != 0) {
    //             TreeNode peek = queue.removeFirst();
    //             if (size == 1) {
    //                 res.add(peek.val);
    //             }
    //             size--;
    //             if (peek.left != null) {
    //                 queue.add(peek.left);
    //             }
    //             if (peek.right != null) {
    //                 queue.add(peek.right);
    //             }
    //         }
    //     }
    //     return res;
    // }

    // dfs
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (depth > res.size()) {
            res.add(root.val);
        }
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }


    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(3);


        // a.left = b;
        a.right = c;
        // b.left = d;
        // b.right = e;
        // c.left = d;
        // c.right = e;

        System.out.println(s.rightSideView(a));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
