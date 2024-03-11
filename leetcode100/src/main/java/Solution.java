class Solution {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return max;
    }

    private int getDepth(TreeNode root) {
        if (root == null) return 0;
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        if (l + r > max) {
            max = l + r;
        }
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;

        System.out.println(s.diameterOfBinaryTree(a));
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
