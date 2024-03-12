import java.util.ArrayList;
import java.util.List;

class Trie {
    List<String> list;
    public Trie() {
        list = new ArrayList<>();
    }

    public void insert(String word) {
        list.add(word);
    }

    public boolean search(String word) {
        if (list.contains(word)) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        int len = prefix.length();
        for (String word : list) {
            if (len > word.length()) continue;
            if (word.substring(0, 0 + len).equals(prefix)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app");     // 返回 True
    }
}