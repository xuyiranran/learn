package learn_data_structure.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

/**
 * 邻接表实现图
 * <p>
 * DFS(深度优先遍历)
 * BFS(广度优先遍历)
 * <p>
 * 打印邻接表数据
 */
public class GraphArrayLinkedList {

    private Map<Integer, LinkedList<Integer>> data = new HashMap<>();

    private int vertexSize;//顶点总数
    private int edgesSize;//边总数
    private boolean[] visited;//顶点访问标识(为BFS和DFS准备)
    private Map<Integer, Boolean> visitedMap = Maps.newHashMap();

    private static class Node {

        public int start;
        public int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public Node() {
        }
    }

    public void cleanVisitedMap() {
        visitedMap = new HashMap<>();
    }

    public GraphArrayLinkedList(int vertexCount, List<Node> list) {
        for (int i = 0; i < vertexCount; i++) {
            data.put(i, new LinkedList<>());
        }
        this.vertexSize = vertexCount;
        for (Node node : list) {
            addEdges(node.start, node.end);
            addEdges(node.end, node.start);
        }
    }

    //添加顶点
    public void addVertex(int vertex) {
        data.put(vertex, new LinkedList<>());
        vertexSize++;
    }

    //添加表
    public void addEdges(int vertex1, int vertex2) {
        checkVertex(vertex1);
        checkVertex(vertex2);
        LinkedList<Integer> vertex1List = data.get(vertex1);
        LinkedList<Integer> vertex2List = data.get(vertex2);
        if (vertex1List.contains(vertex2) && vertex2List.contains(vertex1)) return;
        vertex1List.addFirst(vertex2);
        vertex2List.addFirst(vertex1);
        edgesSize++;
    }

    //深度优先遍历(有点类似二叉树的先序遍历)
    public void DFS(int rootVertex) {
        if (!data.keySet().contains(rootVertex)) throw new IllegalArgumentException("图中不存在该顶点");
        visitedMap.put(rootVertex, true);
        LinkedList<Integer> vertexList = data.get(rootVertex);
        //访问顶点
        System.out.print(rootVertex + "->");
        if (vertexList.isEmpty()) return;
        for (Integer vertex : vertexList) {
            if (!visitedMap.getOrDefault(vertex, false)) {
                DFS(vertex);
            }
        }
    }


    //广度优先遍历(类似二叉树的层级遍历,通过使用一个队列数据结构来实现)
    public void BFS(int rootVertex) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(rootVertex);
        visitedMap.put(rootVertex, true);
        while (!queue.isEmpty()) {
            //访问顶点
            int removeVertex = queue.remove();
            System.out.print(removeVertex + "->");
            visitedMap.put(removeVertex, true);
            LinkedList<Integer> vertexList = data.get(removeVertex);
            for (Integer vertex : vertexList) {
                if (!visitedMap.getOrDefault(vertex, false)) {
                    queue.add(vertex);
                }
            }
        }
    }


    private void checkVertex(int vertex) {
        if (!data.keySet().contains(vertex)) throw new IllegalArgumentException("不存在的顶点");
    }

    public void print() {
        for (int i = 0; i < vertexSize; i++) {
            System.out.print(i + ":");
            for (Integer index : data.getOrDefault(i, Lists.newLinkedList())) {
                System.out.print(index + "->");
            }
            System.out.println();
        }
    }

    public int getVertexSize() {
        return vertexSize;
    }

    public int getEdgesSize() {
        return edgesSize;
    }


    public static void main(String[] args) {

        List<Node> nodes = Lists.newArrayList();
        nodes.add(new Node(0, 3));

        nodes.add(new Node(1, 2));
        nodes.add(new Node(1, 3));
        nodes.add(new Node(1, 5));

        nodes.add(new Node(2, 4));

        nodes.add(new Node(3, 7));

        nodes.add(new Node(6, 7));

        GraphArrayLinkedList grap = new GraphArrayLinkedList(8, nodes);

        grap.print();
        System.out.println("===深度优先遍历");
        grap.DFS(0);
        grap.cleanVisitedMap();
        System.out.println();
        System.out.println("===广度优先遍历");
        grap.BFS(0);


    }


}
