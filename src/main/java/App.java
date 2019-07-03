public class App {

    public static void main(String[] args) {


        int result=Integer.parseInt("0010");
        System.out.println(result);
        System.out.println(Integer.parseInt("0010",3));

        String string=Integer.toBinaryString(8);

        System.out.println(string);

        System.out.println(Integer.parseInt(string)==8);


    }
}
