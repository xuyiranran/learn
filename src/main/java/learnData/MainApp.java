package learnData;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MainApp {


    public static void main(String[] args) {

        PriorityQueue<Integer> queue=new PriorityQueue(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        queue.add(10);
        queue.add(5);
        queue.add(1);
        queue.add(0);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }

}
