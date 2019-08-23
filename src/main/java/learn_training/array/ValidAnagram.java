package learn_training.array;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 242:valid anagram
 * <p>
 * valid anagram定义：
 * abc和acb是valid anagram
 * abc和abd不是valid anagram
 * <p>
 * 解决方法
 * 1、先排序后比对
 * 2、存放到map比对
 */
public class ValidAnagram {

    public boolean validV1(String value1, String value2) {

        if (value1.length() != value2.length()) return false;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        char[] chars1 = value1.toCharArray();
        char[] chars2 = value2.toCharArray();

        for (int i = 0; i < chars1.length; i++) {
            int key = chars1[i] - 'a';
            map1.put(key, map1.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < chars2.length; i++) {
            int key = chars2[i] - 'a';
            map2.put(key, map2.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < chars1.length; i++) {
            int key = chars1[i] - 'a';
            if (map1.getOrDefault(key, 0) != map2.getOrDefault(key, 0)) {
                return false;
            }
        }
        return true;

    }

}
