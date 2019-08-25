package learn_training.find;

import java.util.*;

/**
 *
 * leetcode 49:group anagrams
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串
 *
 *
 *
 */
public class GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();

        for(String string:strs){

            char[] chars=string.toCharArray();
            Arrays.sort(chars);

            List<String> tmp=ans.getOrDefault(new String(chars),null);
            if (tmp!=null){
                tmp.add(string);
            }else {
                tmp=new ArrayList<>();
                tmp.add(string);
                ans.put(new String(chars),tmp);
            }
        }
        return new ArrayList<>(ans.values());
    }



}
