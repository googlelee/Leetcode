import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    // bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> layer = new ArrayList<>();
            while (n-- != 0) {
                TreeNode temp = queue.removeFirst();
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
                layer.add(temp.val);
            }
            res.add(layer);
        }
        return res;
    }


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
        b.right = e;
        c.left = f;
        c.right = g;

        System.out.println(s.levelOrder(a));
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
