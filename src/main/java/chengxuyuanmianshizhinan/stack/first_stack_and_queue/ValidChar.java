package chengxuyuanmianshizhinan.stack.first_stack_and_queue;

import java.util.Stack;

/**
 * 利用栈数据结构判断括号匹配
 * 思路:
 * 1、先将左括号入栈
 * 2、如果遇到右括号就和栈顶元素比对看是否是一对比配括号
 */
public class ValidChar {

    public boolean isValid(String string) {

        Stack<Character> stack = new Stack<>();
        char[] chars = string.toCharArray();
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


    //LeetCode有一个读者提供了这种解法,这个解法是有问题的
    public boolean isValidV2(String string) {

        String tmp = string.replace("()", "");
        tmp.replace("[]", "");
        tmp.replace("{}", "");
        return tmp.isEmpty();
    }

    public static void main(String[] args) {


        ValidChar validChar = new ValidChar();
        System.out.println(validChar.isValid("{()}"));
        System.out.println(validChar.isValid("{()[]{([])}"));
        System.out.println(validChar.isValidV2("([]){}[{}]"));
        System.out.println(validChar.isValid("([]){}[{}]"));

    }

}
