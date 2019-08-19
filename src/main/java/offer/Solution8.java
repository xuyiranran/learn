package offer;

/**
 * 一只青蛙一次可以跳上1级台阶,也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 *
 * 跳1级台阶后的跳跃可能为f(n-1)
 * 跳2两级台阶后的跳跃可能为f(n-2)
 */
public class Solution8 {

    public int JumpFloor(int target) {

        if (target==0)return 0;
        if (target==1)return 1;
        if (target==2)return 2;

        return JumpFloor(target-1)+JumpFloor(target-2);
    }

    public static void main(String[] args) {
        Solution8 solution8=new Solution8();
        int count=solution8.JumpFloor(4);
        System.out.println(count);


    }

}
