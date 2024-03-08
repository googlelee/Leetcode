import java.util.*;

class Solution {

    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, res = 0;
        if (s == null) return 0;
        if (s.length() < 2) return s.length();
        while (r < s.length()) {
            for (int i = l; i < r; i++) {
                if (s.charAt(i) == s.charAt(r)) {
                    l = i + 1;
                }
            }
            if (res < r - l + 1) res = r - l + 1;
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "abcabcbb";
        System.out.println(s.lengthOfLongestSubstring(str));
    }
}