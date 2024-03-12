import javax.swing.plaf.metal.MetalIconFactory;
import java.util.*;

class Solution {

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                sb.reverse();
                stack.pop(); // 去掉左括号
                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty() && !(stack.peek() >= 'a' && stack.peek() <= 'z') && stack.peek() != '[') {
                    num.append(stack.pop());
                }
                num.reverse();
                int n = Integer.parseInt(num.toString());

                StringBuilder item = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    item.append(sb);
                }

                for (int j = 0; j < item.length(); j++) {
                    stack.push(item.charAt(j));
                }

            } else {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        res.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }
}
