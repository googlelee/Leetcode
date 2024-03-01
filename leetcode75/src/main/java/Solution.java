public class Solution {
    public String mergeAlternately(String word1, String word2) {
        int p1 = 0;
        int p2 = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder c = new StringBuilder();
        while (p1 < len1 && p2 < len2) {
            if (p1 <= p2) {
                c.append(word1.charAt(p1));
                p1++;
            } else {
                c.append(word2.charAt(p2));
                p2++;
            }
        }
        if (p1 < len1) c.append(word1, p1, len1);
        if (p2 < len2) c.append(word2, p2, len2);
        return c.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.mergeAlternately("a", "p"));
    }
}