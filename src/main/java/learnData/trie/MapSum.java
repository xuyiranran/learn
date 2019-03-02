package learnData.trie;

import java.util.HashMap;

public class MapSum {


    //根节点
    private Node root;
    //单词总数
    private int size;

    private static class Node {

        //是否是一个单词结尾字符
        boolean isWord;
        //字符指向之后映射
        HashMap<Character, Node> next;
        //单词权重
        int weight;

        public Node() {
            this(false, 0);
        }

        public Node(boolean isWord, int weight) {
            this.isWord = isWord;
            this.next = new HashMap<>();
            this.weight = weight;
        }
    }


    public MapSum() {
        root = new Node();
    }

    public void add(String word, int weight) {

        char[] chars = word.toCharArray();
        Node cur = root;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            HashMap<Character, Node> nextMap = cur.next;
            //如果不存在char[i]映射
            if (nextMap.get(c) == null) {
                nextMap.put(c, new Node());
            }
            cur = nextMap.get(c);
        }
        //只有当最后一个节点不是单词尾字符,才标识和size++.因为可能字典树中之前已经存在了该单词.
        if (!cur.isWord) {
            cur.isWord = true;
            cur.weight = weight;
            size++;
        } else {
            cur.weight = weight;
        }
    }

    public int sum(String prefix) {

        Node cur = root;
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node) {
        int result = node.weight;
        for (char c : node.next.keySet()) {
            result += sum(node.next.get(c));
        }
        return result;
    }


}
