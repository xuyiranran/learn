package leetcode;

import learnData.setAndmap.Set;

import java.util.Collections;
import java.util.HashSet;

public class NumJewelsInStones {

    public int numJewelsInStonesV1(String J, String S) {

        char[] chars = S.toCharArray();
        int slen = chars.length;

        char[] jchar = J.toCharArray();
        for (char one : jchar) {
            S = S.replaceAll(one + "", "");
        }
        return slen - S.toCharArray().length;
    }

    public int numJewelsInStonesV2(String J, String S) {

        int count = 0;
        char[] chars = J.toCharArray();
        HashSet<Character> characterSet = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            characterSet.add(chars[i]);
        }
        char[] schars = S.toCharArray();

        for (int i = 0; i < schars.length; i++) {
            if (characterSet.contains(schars[i])) {
                count++;
            }
        }
        return count;
    }
}
