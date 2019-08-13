package learn_java_juc.thread_local;

public class ThreadLocalDemo {

    ThreadLocal<String> threadLocal=new ThreadLocal<>();

    public void setValue(String value){
        threadLocal.set(value);
    }

    public String getValue(){
        return threadLocal.get();
    }

}
