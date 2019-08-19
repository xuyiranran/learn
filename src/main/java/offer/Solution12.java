package offer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 *
 * 借助队列数据结构来实现
 */
public class Solution12 {

    public void reOrderArray(int [] array) {

        Queue<Integer> num1=new ArrayDeque<>();
        Queue<Integer> num2=new ArrayDeque<>();
        for (int i = 0; i <array.length ; i++) {
            if (array[i]%2==0){
                num2.add(array[i]);
            }else {
                num1.add(array[i]);
            }
        }
        int i=0;
        while (!num1.isEmpty()){
            array[i]=num1.remove();
            i++;
        }
        while (!num2.isEmpty()){
            array[i]=num2.remove();
            i++;
        }
    }



}
