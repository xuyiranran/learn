package learn_training.array;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * leetcode 125:回文串校验
 * <p>
 * <p>
 * aba=>true
 * abc=>false
 * <p>
 * 解法:
 * 1、使用一个栈数据结构来存储比对
 * 2、使用头尾指针指针引用来比对
 */
public class ValidPalindrome {

    /**
     * 使用栈数据结构来处理
     * 时间复杂度:O(N)
     * 空间复杂度:O(N)
     *
     * @param string
     * @return
     */
    public boolean validPalindromeV1(String string) {
        char[] chars = string.toCharArray();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            queue.add(chars[i]);
        }

        for (int i = 0; i < chars.length; i++) {
            if (queue.remove() != chars[i]) return false;
        }
        return queue.isEmpty();
    }


    /**
     * 使用头尾指针(碰撞指针)
     * 时间复杂度:O(N)
     * 空间复杂度:O(1)
     *
     * @param string
     * @return
     */
    public boolean validPalindromeV2(String string) {
        char[] chars = string.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start <= end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {

        ValidPalindrome validPalindrome = new ValidPalindrome();

        System.out.println(validPalindrome.validPalindromeV1("aba"));
        System.out.println(validPalindrome.validPalindromeV2("abc"));

    }

}
