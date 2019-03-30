package leetcode;

public class IsPalindrome {


    public static void main(String[] args) {

        System.out.println(String.valueOf(-123));
        System.out.println(isPalindromeV1(121));
        System.out.println(isPalindromeV2(123213));

    }

    public static boolean isPalindromeV1(int x) {

        String string = String.valueOf(x);
        char[] chars = string.toCharArray();
        int len = chars.length;
        if (len == 1) return true;
        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - 1 - i]) return false;
        }
        return true;
    }


    public static boolean isPalindromeV2(int x) {

        if (x < 0) return false;
        if (x < 10) return true;
        String string = x + "";
        char[] chars = string.toCharArray();
        int len = chars.length;
        if (len == 1) return true;
        for (int i = 0; i < len / 2; i++) {
            if (chars[i] != chars[len - 1 - i]) return false;
        }
        return true;
    }
}
