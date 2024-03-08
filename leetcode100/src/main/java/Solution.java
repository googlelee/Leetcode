import java.util.*;

class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();
        int l = 0, r = 0, res = 0;
        Set<Character> hashSet = new HashSet<>();
        while (r < s.length()) {
            while (hashSet.contains(s.charAt(r))) {
                hashSet.remove(s.charAt(l));
                l++;
            }
            hashSet.add(s.charAt(r));
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