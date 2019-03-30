package leetcode;

public class ToLowerCase {


    public static void main(String[] args) {

        System.out.println('a' + 0);
        System.out.println('z' + 0);
        System.out.println('A' + 0);
        System.out.println('Z' + 0);

    }

    public static String toLowerCase(String str) {

        char[] chars = str.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                chars[i] += 32;
            }
        }
        return new String(chars);
    }

    public static String toLowerCaseV2(String str) {
        return str.toLowerCase();
    }

}
