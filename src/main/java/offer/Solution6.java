package offer;

/**
 * 旋转数组
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 */
public class Solution6 {


    public int minNumberInRotateArray(int [] array) {

        int len=array.length;
        if (len==0)return 0;
        for (int i = 0; i <len-1 ; i++) {
            if (array[i]>array[i+1]){
                return array[i+1];
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Solution6 solution6=new Solution6();
        int ret=solution6.minNumberInRotateArray(new int[]{3,4,5,1,2});

        System.out.println(ret);
    }


}
