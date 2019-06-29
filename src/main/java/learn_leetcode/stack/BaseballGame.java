package learn_leetcode.stack;


import java.util.Stack;

/**
 * leetocde:682题棒球比赛计分
 */
public class BaseballGame {


    static class Solution {
        public int calPoints(String[] ops) {

            int count = 0;
            Stack<Integer> stack = new Stack();
            for (String action : ops) {
                if (action.equals("+")) {
                    int popFirst = stack.pop();
                    int popSecond = stack.pop();
                    stack.push(popSecond);
                    stack.push(popFirst);
                    stack.push(popFirst + popSecond);
                } else if (action.equals("D")) {
                    stack.push(stack.peek() * 2);
                } else if (action.equals("C")) {
                    stack.pop();
                } else {
                    stack.push(Integer.parseInt(action));
                }
            }
            while (!stack.isEmpty()) {
                count += stack.pop();
            }
            return count;

        }
    }


    static class SolutionV2 {
        public int calPoints(String[] ops) {
            int count = 0;
            int[] sum=new int[ops.length];
            int i=0;
            for (String action : ops) {
                if (action.equals("+")) {
                    sum[i]=sum[i-1]+sum[i-2];
                    i++;
                } else if (action.equals("D")) {
                    sum[i]=sum[i-1]*2;
                    i++;
                } else if (action.equals("C")) {
                    sum[i-1]=0;
                    i--;//要保证每个下标都有值,即每个下标都是一个有效回合.
                } else {
                    sum[i]=Integer.parseInt(action);
                    i++;
                }
            }
            for (int j = 0; j < i; j++) {
                count+=sum[j];
            }
            return count;

        }
    }


    public static void main(String[] args) {

        SolutionV2 solution = new SolutionV2();
        int count = solution.calPoints(new String[]{"5", "2", "C", "D", "+"});

        System.out.println(count);

    }
}
