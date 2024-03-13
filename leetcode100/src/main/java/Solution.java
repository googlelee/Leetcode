import javax.management.relation.InvalidRoleInfoException;
import java.util.*;

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hashMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, hashMap);
    }

    private TreeNode build(int[] preorder, int[] inorder, int pl, int pr, int il, int ir, Map<Integer, Integer> hashMap) {
        if (pl > pr) return null;
        TreeNode root = new TreeNode(preorder[pl]);
        int rootPos = hashMap.get(root.val);
        root.left = build(preorder, inorder, pl + 1, pl + rootPos - il, il, rootPos - 1, hashMap);
        root.right = build(preorder, inorder, pl + rootPos - il + 1, pr, rootPos + 1, ir, hashMap);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        System.out.println(s.buildTree(preorder, inorder));
    }
}
