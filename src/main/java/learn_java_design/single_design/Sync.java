package learn_java_design.single_design;

public class Sync {

    private static Sync sync=new Sync();

    public String syncMethod(String msg) {
        return msg;
    }

    public String simpleMethod(String msg) {
        return msg;
    }

    public static void main(String[] args) {

        Sync sync = new Sync();

        Sync.sync=new Sync();

        long cur = System.currentTimeMillis();
        int times = 1000000000;
        for (int i = 0; i < times; i++) {
            sync.syncMethod("hello");
        }
        System.out.println(System.currentTimeMillis() - cur);
        cur = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            sync.simpleMethod("hello");
        }
        System.out.println(System.currentTimeMillis() - cur);
    }

}
