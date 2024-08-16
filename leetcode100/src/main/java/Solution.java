import java.util.*;

class Solution {
    // 思路 ： 获取节点路径 最后一个相同的节点就是结果
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        dfs(root, p, path, pPath);
        List<TreeNode> qPath = new ArrayList<>();
        dfs(root, q, path, qPath);
        TreeNode result = null;
        for (int i = 0; i < Math.min(pPath.size(), qPath.size()); i++) {
            if (pPath.get(i) != qPath.get(i)) {
                return result;
            } else {
                result = pPath.get(i);
            }
        }
        return result;
    }

    private void dfs(TreeNode root, TreeNode p, List<TreeNode> path, List<TreeNode> ans) {
        if (root == p) {
            ans.addAll(path);
            ans.add(root);
            return;
        }
        path.add(root);
        if (root.left != null) {
            dfs(root.left, p, path, ans);
        }
        if (root.right != null) {
            dfs(root.right, p, path, ans);
        }
        path.remove(root);
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