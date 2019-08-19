package offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 *
 * 1->1
 * 2->2
 * 3->4
 * 4->8
 *
 * 通过数据归纳法和猜想得到f(n)=2f(n-1)
 *
 */
public class Solution9 {

    public int JumpFloorII(int target) {

        if (target==0)return 0;
        if (target==1)return 1;
        return 2*JumpFloorII(target-1);

    }

    public static void main(String[] args) {
        Solution9 solution9=new Solution9();

        System.out.println(solution9.JumpFloorII(5));

    }



}
