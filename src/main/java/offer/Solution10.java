package offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 *
 *
 */
public class Solution10 {

    public int NumberOf1(int n) {
        int count = 0;
        for (int i = 0; i <32 ; i++) {

            if ((n&1)==1){
                count++;
            }
            n=n>>>1;
        }
        return count;
    }

    public static void main(String[] args) {


        Solution10 solution10=new Solution10();
        System.out.println(5 & 1);//1
        System.out.println(5 >>> 1 & 1);//0
        System.out.println(5 >>> 2 & 1);//1

        System.out.println(solution10.NumberOf1(5));

    }


}
