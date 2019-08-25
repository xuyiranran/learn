package learn_training.stack_queue_heap;


import java.util.Stack;

/**
 *
 * leetcode 20:valid parenthese(括号有效性校验)
 *
 *
 */
public class ValidParenthese {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        if (chars.length % 2 != 0) return false;
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (c == ')' && '(' != stack.pop()) return false;
                if (c == ']' && '[' != stack.pop()) return false;
                if (c == '}' && '{' != stack.pop()) return false;
            }
        }
        return stack.isEmpty();
    }

}
