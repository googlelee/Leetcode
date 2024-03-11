class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                StringBuilder stringBuilder = new StringBuilder();
                boolean[][] mark = new boolean[board.length][board[0].length];
                if (backtrace(board, mark, i, j, word, 0, stringBuilder)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrace(char[][] board, boolean[][] mark, int i, int j, String word, int k, StringBuilder stringBuilder) {
        if (k == word.length() || i >= board.length || j >= board[0].length || i < 0 || j < 0 || stringBuilder.toString().equals(word)) {
            return stringBuilder.toString().equals(word);
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        if (!mark[i][j] && board[i][j] == word.charAt(k)) {
            stringBuilder.append(word.charAt(k));
            mark[i][j] = true;
            for (int l = 0; l < 4; l++) {
                if (backtrace(board, mark, i + dx[l], j + dy[l], word, k+1, stringBuilder)) {
                    return true;
                }
            }
            mark[i][j] = false;
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        System.out.println(s.exist(board, "AAB"));
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
