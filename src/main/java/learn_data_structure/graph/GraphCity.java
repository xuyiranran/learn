package learn_data_structure.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 使用邻接矩阵表示图
 */
public class GraphCity {


    private Set<String> vertex;//A,B,C,D
    private int[][] edges;


    private int vertexSize;
    private int edgesSize;


    public GraphCity(int vertexNum){
        vertex=new HashSet<>();
        edges=new int[vertexNum][];
    }

    public int getVertexSize() {
        return vertex.size();
    }

    public int getEdgesSize() {
        return edgesSize;
    }

    public void addEdges(int vertex1, int vertex2){
        edges[vertex1][vertex2]=1;
        edges[vertex2][vertex1]=1;
        edgesSize++;
    }

    public void addVertex(int vertex){



    }







}
