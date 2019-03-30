package learnData.trie;

import org.omg.CORBA.NO_IMPLEMENT;

import java.util.HashMap;

/**
 * Trie字典树(前缀树)在解决字符串方面领域有一定的优点
 */
public class Trie {

    //根节点
    private Node root;
    //单词总数
    private int size;

    private static class Node {

        //是否是一个单词结尾字符
        boolean isWord;
        //字符指向之后映射
        HashMap<Character, Node> next;

        public Node() {
            this(false);
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new HashMap<>();
        }

    }

    public Trie() {
        root = new Node();
    }

    /**
     * 添加单词
     *
     * @param word
     */
    public void add(String word) {

        char[] chars = word.toCharArray();
        Node cur = root;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            HashMap<Character, Node> nextMap = cur.next;
            //如果不存在char[i]映射
            if (nextMap.get(c) == null) {
                nextMap.put(c, new Node(false));
            }
            cur = nextMap.get(c);
        }
        //只有当最后一个节点不是单词尾字符,才标识和size++.因为可能字典树中之前已经存在了该单词.
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }

    }

    /**
     * 判断是否包含单词
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {
        char[] chars = word.toCharArray();
        Node cur = root;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            HashMap<Character, Node> nextMap = cur.next;
            if (nextMap.get(c) == null) return false;
            cur = cur.next.get(c);
        }
        //只有当最后一个字符是单词结尾才返回true
        return cur.isWord;
    }

    /**
     * 判断是否包含前缀
     *
     * @param prefix
     * @return
     */
    public boolean startWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node cur = root;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            HashMap<Character, Node> nextMap = cur.next;
            if (nextMap.get(c) == null) return false;
            cur = nextMap.get(c);
        }
        return true;
    }

    /**
     * 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母
     *
     * @return
     */
    public boolean match(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if (index >= word.length()) return node.isWord;
        char c = word.toCharArray()[index];
        //如果当前字符不是通配符
        if (c != '.') {
            if (node.next.get(c) == null) return false;
            return match(node.next.get(c), word, index + 1);
        } else {
            for (char any : node.next.keySet()) {
                if (match(node.next.get(any), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }


    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.add("app");
        trie.add("apple");
        System.out.println(trie.contains("ap"));
        System.out.println(trie.contains("apple"));
        System.out.println(trie.contains("app"));
        System.out.println(trie.startWith("ap"));
        System.out.println(trie.startWith("app"));
        System.out.println(trie.match("a..e"));
    }

}
