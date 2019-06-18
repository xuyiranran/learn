package graph;


import com.google.common.graph.Graph;
import com.google.common.graph.GraphBuilder;
import com.google.common.graph.Graphs;
import com.google.common.graph.MutableGraph;

import java.util.Iterator;
import java.util.Set;

public class GraphTest {


    public static void main(String[] args) {

        MutableGraph<String> graph= GraphBuilder.directed().build();


        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addNode("e");

        graph.putEdge("a","b");
        graph.putEdge("a","d");
        graph.putEdge("b","c");
        graph.putEdge("d","c");
        graph.putEdge("d","e");


        Set<String> reachASet=Graphs.reachableNodes(graph,"d");
        System.out.println(reachASet);

        Set<String> reachCSet=Graphs.reachableNodes(graph,"c");
        System.out.println(reachCSet);

    }

}
