package learn_leetcode;

public class FibolacciFunction {

    public static void main(String[] args) {

        System.out.println(fibolacci(3));
        System.out.println(fibolacci(4));
        System.out.println(fibolacci(30));

    }

    private static int fibolacci(int n){
        if (n==1||n==2)return 1;
        return fibolacci(n-1)+fibolacci(n-2);
    }

}
