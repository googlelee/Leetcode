import javax.xml.stream.FactoryConfigurationError;

class Solution {
    // 中心扩散
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] odd = palindromeList(s, i, i);
            int[] even = palindromeList(s, i, i + 1);
            if (even[1] > odd[1]) {
                if (maxLen < even[1]) {
                    maxLen = even[1];
                    start = even[0];
                }
            } else {
                if (maxLen < odd[1]) {
                    maxLen = odd[1];
                    start = odd[0];
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    private int[] palindromeList(String s, int c1, int c2) {
        int left = c1, right = c2;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else break;
        }
        return new int[]{left + 1, right - 1 - left};
    }


    // 动态规划：转移方程当前的状态取决于左下角状态 所以填充顺序要考虑
    // public String longestPalindrome(String s) {
    //     boolean[][] dp = new boolean[s.length()][s.length()];
    //     if (s.length() == 1) return s; // 边界 a
    //     int max = 0;
    //     int start = 0;
    //     int end = 1; // 边界 ab
    //     for (int j = 1; j < s.length(); j++) {
    //         for (int i = 0; i < j; i++) {
    //             boolean equal = s.charAt(i) == s.charAt(j);
    //             if (j - i < 3) dp[i][j] = equal;
    //             else dp[i][j] = dp[i + 1][j - 1] && equal;
    //             if (dp[i][j] && max < j - i) {
    //                 max = j - i;
    //                 start = i;
    //                 end = j + 1;
    //             }
    //         }
    //     }
    //     return s.substring(start, end);
    // }


    public static void main(String[] args) {

        Solution s = new Solution();
        String str = "ab";
        System.out.println(s.longestPalindrome(str));
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
