import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String key = new String(tmp);
            List<String> ss = hashMap.getOrDefault(key, new ArrayList<>());
            ss.add(strs[i]);
            hashMap.put(key, ss);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(s.groupAnagrams(strs));
    }
}