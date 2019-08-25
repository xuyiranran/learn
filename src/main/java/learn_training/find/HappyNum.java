package learn_training.find;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 202:happy number
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数
 *
 *
 *
 *
 *
 */
public class HappyNum {


    /**
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {

        Set<Integer> records=new HashSet<>();
        int tmp=0;
        while (true){
            //这两行代码是循环处理关键
            while (n!=0){
                tmp+=Math.pow(n%10,2);
                n=n/10;
            }
            if (tmp==1){
                return true;
            }else {
                if (records.contains(tmp)){
                    return false;
                }else {
                    records.add(tmp);
                    n=tmp;
                    tmp=0;
                }
            }
        }
    }




}
