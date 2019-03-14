package learnjavase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestModifyException {


    public static void main(String[] args) {

        List<String> books=new ArrayList<>();
        books.add("java");
        books.add("C");

//
//        Iterator<String> iterator=books.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        for (String book:books){
            System.out.println(book);
        }

        System.out.println(books.size());

    }

}
