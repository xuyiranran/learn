package learnData.linklist;

public class Linklist<E> {


    private Node<E> head;

    private int size;

    private static class Node<E>{
        private E e;
        private Node<E> next;

        public Node(E e,Node node){
            this.e=e;
            this.next=node;
        }

        public Node(E e){
            this.e=e;
            this.next=null;
        }
    }

    public Linklist(E e){
        head=new Node<>(e,null);
    }

    public Linklist(){
        this(null);
    }

    public void addFirst(E e){
        Node<E> node=new Node<>(e);
        node.next=head.next;
        head.next=node;
        size++;
    }

    public void addLast(E e){
        Node<E> node=new Node<>(e);
        Node tmp=head;
        while (tmp.next!=null){
             tmp=tmp.next;
        }
        tmp.next=node;
        size++;
    }

    public E removeLast(E e){
        Node<E> tmp=head;
        while (tmp.next.next!=null){
            tmp=tmp.next;
        }
        E removeData=tmp.next.e;
        tmp.next=null;
        size--;
        return removeData;
    }


    @Override
    public String toString() {
        Node<E> tmp=head;
        StringBuilder sb=new StringBuilder();
        while (tmp!=null){
            if (tmp.e!=null){
                sb.append(tmp.e+"->");
            }
            tmp=tmp.next;
        }
        sb.append("linklist:"+size);
        return sb.toString();

    }

    public static void main(String[] args) {

        Linklist<Integer> linklist=new Linklist<>();
        for (int i = 0; i <5 ; i++) {
            linklist.addFirst(i);
        }
        System.out.println(linklist);
    }
}
