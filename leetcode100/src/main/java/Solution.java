import java.util.ArrayList;
import java.util.List;

class Solution {

    List<TreeNode> path;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        dfs(root, p, pPath);
        pPath = path;
        path = null;
        dfs(root, q, qPath);
        qPath = path;
        TreeNode res = null;
        for (int i = 0; i < Math.min(pPath.size(), qPath.size()); i++) {
            if (pPath.get(i) == qPath.get(i)) res = path.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null || this.path != null) {
            return;
        }
        path.add(root);
        if (root == target) {
            this.path = new ArrayList<>(path);
            return;
        }
        dfs(root.left, target, path);
        dfs(root.right, target, path);
        path.removeLast();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(1);
        TreeNode d = new TreeNode(6);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(0);
        TreeNode g = new TreeNode(8);
        TreeNode h = new TreeNode(7);
        TreeNode i = new TreeNode(4);


        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = g;
        e.left = h;
        e.right = i;

        System.out.println(s.lowestCommonAncestor(a, b, i).val);
    }
}
