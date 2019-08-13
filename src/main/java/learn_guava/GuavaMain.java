package learn_guava;

import com.google.common.collect.Lists;

import java.util.List;

public class GuavaMain {

    public static void main(String[] args) {

        List<String> strings= Lists.newArrayList();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
        strings.add("6");

        List<List<String>> lists=Lists.partition(strings,4);

        for (List<String> list:lists) {
            System.out.println(list);
        }



    }



}
