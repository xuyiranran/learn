package learn_leetcode.stack;

import java.util.Stack;

public class LeetCode884 {

    static class Solution {
        public boolean backspaceCompare(String S, String T) {

            return fix(S).equals(fix(T));
        }

        public static String fix(String string) {
            Stack<Character> stack = new Stack<>();
            char[] characters = string.toCharArray();
            for (int i = 0; i < characters.length; i++) {
                char ch = characters[i];
                if (stack.isEmpty()) {
                    if (ch != '#') {
                        stack.push(ch);
                    }
                } else {
                    if (characters[i] == '#') {
                        stack.pop();
                    } else {
                        stack.push(characters[i]);
                    }
                }
            }
            if (stack.isEmpty()) return "";
            char[] chars = new char[stack.size()];
            int i = 0;
            int size = stack.size();
            while (!stack.isEmpty()) {
                chars[size - 1 - i] = stack.pop();
                i++;
            }
            return new String(chars);
        }


        static class SolutionV2 {
            public boolean backspaceCompare(String S, String T) {
                return fix(S).equals(fix(T));
            }

            public static String fix(String string) {

                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < string.length(); i++) {
                    if (string.charAt(i) == '#') {
                        if (stringBuilder.length() > 0) {
                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                        }
                    } else {
                        stringBuilder.append(string.charAt(i));
                    }
                }
                return stringBuilder.toString();
            }
        }


        public static void main(String[] args) {

            String result = Solution.fix("ab##c#dfa");
            System.out.println(result);

            SolutionV2 solution = new SolutionV2();
            System.out.println(solution.backspaceCompare("ab#c", "ad#c"));

        }

    }

}
