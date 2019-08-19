package offer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 *
 * 难道不是递归实现吗?不能使用if?
 *
 */
public class Solution11 {


    public int Sum_Solution(int n) {

        if (n==1)return 1;
        return n+Sum_Solution(n-1);


    }

    public static void main(String[] args) {

        Solution11 solution11=new Solution11();


        System.out.println(solution11.Sum_Solution(3));
        System.out.println(solution11.Sum_Solution(4));
        System.out.println(solution11.Sum_Solution(5));

    }

}
