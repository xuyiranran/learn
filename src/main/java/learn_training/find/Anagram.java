package learn_training.find;

import java.util.Arrays;
import java.util.HashMap;

/**
 * leetcode 242:valid anagram
 *
 * 有效的字母异位词
 * 
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
 *
 *
 */
public class Anagram {


    /**
     * 使用hashmap来比对
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {


        if (s.length()!=t.length())return false;
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();

        HashMap<Character, Integer> firstMap = new HashMap<>();
        for (int i = 0; i < first.length; i++) {
            int old = firstMap.getOrDefault(first[i], 0);
//            old++;
            firstMap.put(first[i], ++old);
        }

        for (int i = 0; i < second.length; i++) {
            int old = firstMap.getOrDefault(second[i], 0);
            if (old == 0) {
                return false;
            } else {
                old--;
                if (old == 0) {
                    firstMap.remove(second[i]);
                } else {
                    firstMap.put(second[i], old);
                }
            }
        }
        return firstMap.isEmpty();
    }

    /**
     * 先排序再比对
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramV2(String s, String t) {
        if (s.length()!=t.length())return false;
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        Arrays.sort(first);
        Arrays.sort(second);
        return new String(first).equals(new String(second));
    }

    public static void main(String[] args) {

        Anagram anagram=new Anagram();

        boolean result=anagram.isAnagram("anagram","nagaram");

        System.out.println(result);
    }


}
