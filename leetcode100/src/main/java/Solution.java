import javax.management.relation.InvalidRoleInfoException;
import java.util.*;

class Solution {

    int res = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<TreeNode, List<Long>> hashMap = new HashMap<>();
        dfs(root, new ArrayList<>(), targetSum);
        return res;
    }

    private void dfs(TreeNode root, List<Long> nums, int targetSum) {
        if (root == null) return;
        for (int i = 0; i < nums.size(); i++) {
            nums.set(i, nums.get(i) + root.val);
            if (nums.get(i) == targetSum)
                res++;
        }
        nums.add(Long.valueOf(root.val));
        if (root.val == targetSum)
            res++;
        dfs(root.left, new ArrayList<>(nums), targetSum);
        dfs(root.right, new ArrayList<>(nums), targetSum);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode a = new TreeNode(10);
        TreeNode b = new TreeNode(5);
        TreeNode c = new TreeNode(-3);
        TreeNode d = new TreeNode(3);
        TreeNode e = new TreeNode(2);
        TreeNode f = new TreeNode(11);
        TreeNode g = new TreeNode(3);
        TreeNode h = new TreeNode(-2);
        TreeNode i = new TreeNode(1);


        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;
        d.left = g;
        d.right = h;
        e.right = i;

        s.pathSum(a, 8);
        System.out.println(s.res);
    }
}
