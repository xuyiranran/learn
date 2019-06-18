package learnjavase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        List<Long> list=new ArrayList<>();
        list.add(12l);
        list.add(12l);
        list.add(13l);
        list=new ArrayList<>(new HashSet<>(list));

        System.out.println(list);

        System.out.println(String.format("hello %s","world"));



    }
}
