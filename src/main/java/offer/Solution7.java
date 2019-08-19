package offer;

/**
 * 斐波那契数列
 *
 * 0,1,1,2,3,5,8....
 *
 * 递归分析求解
 * f(n)=f(n-1)+f(n-2)
 *
 * 可以使用数学归纳法求解
 */
public class Solution7 {


    public int Fibonacci(int n) {

        if (n==0)return 0;
        if (n==1||n==2)return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    public static void main(String[] args) {

        Solution7 solution=new Solution7();

        System.out.println(solution.Fibonacci(5));
        System.out.println(solution.Fibonacci(6));
        System.out.println(solution.Fibonacci(7));


    }

}
