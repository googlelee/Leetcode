class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        int len = nums.length;
        TreeNode head = new TreeNode(nums[len / 2]);
        int[] leftArray = new int[len / 2];
        int[] rightArray;
        int rightLen;
        if (len % 2 == 0) {
            rightArray = new int[len / 2 - 1];
            rightLen = len / 2 - 1;
        } else {
            rightArray = new int[len / 2];
            rightLen = len / 2;
        }

        System.arraycopy(nums, 0, leftArray, 0, len / 2);
        System.arraycopy(nums, len / 2 + 1, rightArray, 0, rightLen);
        head.left = sortedArrayToBST(leftArray);
        head.right = sortedArrayToBST(rightArray);
        return head;
    }


    public static void main(String[] args) {

        Solution s = new Solution();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode head = s.sortedArrayToBST(nums);
        System.out.println();
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
