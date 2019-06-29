package learn_leetcode.stack;

import java.util.Stack;

/**
 * LeetCode:1047-删除字符串中的所有相邻重复项
 */
public class RemoveDuplicatesFunction {

    static class Solution {



        public String removeDuplicates(String S) {

            Stack<Character> characterStack = new Stack<>();
            char[] chars = S.toCharArray();
            for (Character character : chars) {
                if (characterStack.isEmpty()) {
                    characterStack.push(character);
                } else {
                    Character peek = characterStack.peek();
                    if (peek != character) {
                        characterStack.push(character);
                    }
                    if (peek==character){
                        characterStack.pop();
                    }
                }
            }
            int size = characterStack.size();
            char[] chars1 = new char[characterStack.size()];
            int i = 0;
            while (!characterStack.isEmpty()) {
                chars1[size - 1 - i] = characterStack.pop();
                i++;
            }
            return new String(chars1);
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String result = solution.removeDuplicates("abbaca");

        System.out.println(result);
    }

}
