package offer;

/**
 * 替换空格
 * 1、使用原生String功能
 * 2、使用字符数组分析
 */
public class Solution2 {


    public String replaceSpace(StringBuffer str) {

        char[] chars=str.toString().toCharArray();
        int spaceCount=0;
        for (int i = 0; i <chars.length ; i++) {
            if (chars[i]==' '){
                spaceCount++;
            }
        }
        char[] result=new char[chars.length+2*spaceCount];
        int j=0;
        for (int i = 0; i <chars.length ; i++) {
            if (chars[i]!=' '){
                result[j]=chars[i];
                j++;
            }else {
                result[j]='%';
                result[j+1]='2';
                result[j+2]='0';
                j=j+3;
            }
        }
        return new String(result);
    }

    public String replaceSpace2(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }

    public static void main(String[] args) {


        Solution2 solution2=new Solution2();

        System.out.println(solution2.replaceSpace(new StringBuffer("we are happy")));
        System.out.println(solution2.replaceSpace2(new StringBuffer("we are happy")));


    }



}
