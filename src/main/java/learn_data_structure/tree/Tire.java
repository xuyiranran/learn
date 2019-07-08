package learn_data_structure.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 字典树(Tire前缀树)
 */
public class Tire {

    private Node root;
    private int size;

    private static class Node {
        private Map<Character, Node> next = new HashMap<>();
        private Character character;
        private boolean isWord;
        public Node(Character character) {
            this.character = character;
        }
        public Node() {

        }
    }

    public Tire(){
        root=new Node();
    }

    //添加单词
    public void add(String word){
        char[] chars=word.toCharArray();
        Node cur=root;
        for (int i = 0; i <chars.length ; i++) {
            char character=chars[i];
            Map<Character,Node> map=cur.next;
            Node node=map.getOrDefault(character,null);
            if (node==null){
                map.put(character,new Node(character));
            }else {

            }
            cur=map.get(character);
        }
        if (!cur.isWord){
            //只有当最后一个节点不是单词尾字符,才标识和size++.因为可能字典树中之前已经存在了该单词.
            cur.isWord=true;
            size++;
        }
        if (cur.isWord){
            //表明添加的这个单词之前已经存在于字典树种了
        }
    }

    //查询字典树是否包含某个单词
    public boolean contains(String word){
        char[] chars=word.toCharArray();
        Node cur=root;
        for (int i = 0; i <chars.length ; i++) {
            char character=chars[i];
            Map<Character,Node> map=cur.next;
            Node node=map.getOrDefault(character,null);
            if (node==null)return false;
            cur=node;
        }
        return cur.isWord;
    }

    //查询是否包含prefix前缀的单词
    public boolean startWithPrefix(String prefix){

        char[] chars=prefix.toCharArray();
        Node cur=root;
        for (int i = 0; i <chars.length ; i++) {

            char character=chars[i];
            Map<Character,Node> map=cur.next;
            Node node=map.getOrDefault(character,null);
            if (node==null){
                return false;
            }
            cur=node;
        }
        return !cur.isWord;

    }


    /**
     * 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母
     * @return
     */
    public boolean search(String word) {
        return match(word.toCharArray(),root,0);
    }

    private boolean match(char[] chars,Node node,int index){

        if (index>chars.length-1)return false;
        Map<Character,Node> map=node.next;
        Node cur=map.getOrDefault(chars[index],null);
        if (chars[index]=='.'){
            Set<Character> keys=map.keySet();
            for(Character character:keys){
                if (map.getOrDefault(character,null)!=null){
                    return true;
                }
            }
            return false;
        }else {
            if (cur==null){
                return false;
            }
            return match(chars,cur,index+1);
        }
    }

    public static void main(String[] args) {


        Tire tire=new Tire();

        tire.add("A");
        tire.add("hello");
        tire.add("apple");

        System.out.println(tire.contains("apple"));
        System.out.println(tire.contains("A"));
        System.out.println(tire.contains("AB"));

        System.out.println(tire.search("a.p.e"));
        System.out.println(tire.search("..."));



    }


}
