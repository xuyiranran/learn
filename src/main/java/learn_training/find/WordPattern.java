package learn_training.find;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 290:word pattern
 *
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律
 */
public class WordPattern {


    public boolean wordPattern(String pattern, String str) {

        char[] chars=pattern.toCharArray();
        String[] strings=str.split(" ");
        if (chars.length!=strings.length)return false;
        Map<Character,String> map=new HashMap<>();

        for (int i = 0; i <chars.length-1 ; i++) {

            String oldString=map.getOrDefault(chars[i],null);
            String oldString2=map.getOrDefault(chars[i+1],null);
            if (oldString!=null&&!oldString.equals(strings[i])){
                return false;
            }
            if (oldString2!=null&&!oldString2.equals(strings[i+1])){
                return false;
            }
            map.put(chars[i],strings[i]);
            if (chars[i]==chars[i+1]){
                if (!strings[i].equals(strings[i+1])){
                    return false;
                }
            }else {
                if (strings[i].equals(strings[i+1])){
                    return false;
                }
            }
        }
        return true;
    }



}
