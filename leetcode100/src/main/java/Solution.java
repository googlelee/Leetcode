import javax.swing.plaf.metal.MetalIconFactory;
import java.util.*;

class Solution {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[') {
                    sb.insert(0, stack.pop());
                }
                stack.pop(); // 去掉左括号
                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty() && !(stack.peek() >= 'a' && stack.peek() <= 'z') && stack.peek() != '[') {
                    num.insert(0, stack.pop());
                }
                int n = Integer.parseInt(num.toString());

                StringBuilder item = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < sb.length(); k++) {
                        stack.push(sb.charAt(k));
                    }
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.decodeString("3[a]2[bc]"));
    }
}
