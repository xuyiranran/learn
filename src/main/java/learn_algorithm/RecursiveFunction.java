package learn_algorithm;

/**
 * 递归思想
 * 递归思想是算法设计当中非常重要的一种程序实现手段
 * <p>
 * 尤其是链表操作和二叉树以及图的操作中,使用递归函数来解决问题有时候会很简单.
 * 当然不使用递归本质上也能解决,但是会比较复杂.(因为递归就是借助函数调用栈实现的)
 */
public class RecursiveFunction {


    /**
     * n=1+2+...+n
     *
     * @param n
     * @return
     */
    public int count(int n) {
        if (n == 1) return 1;
        return n + count(n - 1);
    }


    /**
     * 斐波拉契数列
     * 1,1,2,3,5,8,13...
     *
     * @param n
     * @return
     */
    public int Fibolacci(int n) {
        if (n == 1 || n == 2) return 1;
        return Fibolacci(n - 1) + Fibolacci(n - 2);
    }


}
