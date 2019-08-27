package learn_data_structure.graph;

import java.util.*;

public class Graph {


    private int edgeCount;
    private int vertxCount;
    private Set<Integer> vertxs = new HashSet<>();
    private Map<Integer, LinkedList<Integer>> map = new HashMap<>();


    //添加有向边
    public void addEdge(int vertx1, int vertx2) {




    }


    public void addVertx(int vertx) {
        if (vertxs.contains(vertx)) {
            return;
        }
        vertxs.add(vertx);
        vertxCount++;
    }


}
