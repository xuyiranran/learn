package leetcode;

public class MaxInt {


    public static void main(String[] args) {

        System.out.println(max(695, 1112));
        System.out.println(max(1112, 695));

    }

    /**
     * 求取最大公约数
     *
     * @param a
     * @param b
     * @return
     */
    private static int max(int a, int b) {
        if (a == 1 || b == 1) return 1;
        int result = a % b;
        if (result == 0) return b;
        return max(b, result);
    }


    /**
     * 判断一个数是否是素数
     * 常规思维:判断从2开始直到n-1是否存在能被整除的数,存在则不是素数
     * @param num
     * @return
     */
    private static boolean isPrimeV1(int num) {
        if (num < 3) {
            return num > 1;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    /**
     * 判断一个数是否是素数
     * 优化循环次数,一个数的开平方值是最大的.
     *
     * @param num
     * @return
     */
    private static boolean isPrimeV2(int num) {
        if (num < 3) {
            return num > 1;
        }
        int max = (int) Math.sqrt(num);
        for (int i = 2; i < max; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }


}