package design;

public class MainApp {

    private static final String BUSSINESS_ORDER = "openapi:2516307770";
    public static void main(String[] args) {


        String string="2516307770,12";
        System.out.println(string.contains(BUSSINESS_ORDER.replaceAll("openapi:","")));


    }
}
