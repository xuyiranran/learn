package learnjavase;


import java.util.HashMap;
import java.util.Map;

public class Hello {

    public static void main(String[] args) {
        Map<String,String> map=new HashMap();
        map.put("123","value");
        System.out.println(map.get(Long.valueOf(123)));
    }

}
