package learnData.trie;

import java.util.HashMap;

/**
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 */
public class WordDictionary {


    //根节点
    private Node root;
    private int size;

    private static class Node {

        //是否是单词结尾
        boolean isWord;
        //字符指向之后映射
        HashMap<Character, Node> next;

        public Node() {
            this.isWord = false;
            this.next = new HashMap<>();
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new HashMap<>();
        }

    }

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {

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
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    /**
     * 模式匹配搜索单词,注意这里要求的必须是单词所以需要维护是否为单词,和前缀匹配不一样.
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if (index == word.length()) return node.isWord;
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

}
