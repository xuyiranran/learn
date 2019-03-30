package leetcode;

/**
 * 第一次出现的唯一元素
 */
public class FIrstUniqChar {


    public int firstUniqChar(String s) {

        char[] chars = s.toCharArray();
        int[] indexs = new int[26];
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            indexs[chars[i] - 'a'] += 1;
        }
        for (int i = 0; i < len; i++) {
            if (indexs[chars[i] - 'a'] == 1) return i;
        }
        return -1;
    }

}
