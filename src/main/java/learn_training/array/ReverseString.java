package learn_training.array;

/**
 * leetcode 344:reverse String(反转字符串)
 * <p>
 * 1、使用碰撞指针(比较优秀的最优解法)
 * 2、使用栈数据结构(正常思维的解法)
 */
public class ReverseString {


    public String reverseString(String string) {
        char[] chars = string.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            swap(chars, start++, end--);
        }
        return new String(chars);
    }

    private void swap(char[] chars, int x, int y) {
        char tmp = chars[x];
        chars[x] = chars[y];
        chars[y] = tmp;
    }

    public static void main(String[] args) {

        ReverseString reverseString = new ReverseString();
        String result = reverseString.reverseString("hello china");
        System.out.println(result);


    }

}
