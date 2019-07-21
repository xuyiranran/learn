package learn_data_structure;

import java.util.Stack;

public class Hannuota {


    public void hannuo(int num, char a, char b, char c) {
        //最简单问题
        if (num == 1) {
            System.out.println(a + "移动到->" + c);
        } else {
            //把n-1的盘移动到b
            hannuo(num - 1, a, c, b);
            //把最下面的盘移动到c
            System.out.println(a + "移动到->" + c);
            //把n-1的盘从b移动到c
            hannuo(num - 1, b, a, c);
        }
    }

    public static void main(String[] args) {

        Hannuota hannuota = new Hannuota();
        hannuota.hannuo(10, 'A', 'B', 'C');

    }

}
