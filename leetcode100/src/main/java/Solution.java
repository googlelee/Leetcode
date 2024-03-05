class Solution {
    // 递归
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValid(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if (root.val <= minValue || root.val >= maxValue) return false;
        return isValid(root.left, minValue, root.val) && isValid(root.right, root.val, maxValue);
    }

    // 中序遍历
    // long min = Long.MIN_VALUE;
    // public boolean isValidBST(TreeNode root) {
    //     if (root == null) return true;
    //
    //     if (!isValidBST(root.left)) {
    //         return false;
    //     }
    //
    //     if (root.val <= min) return false;
    //
    //     min = root.val;
    //
    //     return isValidBST(root.right);
    // }

    public static void main(String[] args) {

        Solution s = new Solution();

        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(6);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(7);
        TreeNode f = new TreeNode(4);
        TreeNode g = new TreeNode(3);


        a.left = b;
        a.right = c;
        // b.left = d;
        // b.right = e;
        c.left = d;
        c.right = e;

        System.out.println(s.isValidBST(a));
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
