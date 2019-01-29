package learnData.linklist;

public class LinkedList<E> {


    private Node<E> head;

    /** 虚拟节点*/
    private Node<E> dummyHead;

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

        public Node(){
            this.e=null;
            this.next=null;
        }
    }

    public LinkedList(E e){
        dummyHead=new Node<>();
        head=new Node<>(e,null);
    }

    public LinkedList(){
        this(null);
    }

    public void addFirst(E e){
        Node<E> node=new Node<>(e);
        Node<E> pre=dummyHead;
        node.next=pre.next;
        pre.next=node;
        size++;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
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
        Node<E> cur=dummyHead.next;
        while (cur!=null){
            sb.append(cur.e.toString()+"->");
            cur=cur.next;
        }
        sb.append("linklist:"+size);
        return sb.toString();

    }

    public static void main(String[] args) {

        LinkedList<Integer> linkedList =new LinkedList<>();
        for (int i = 0; i <5 ; i++) {
            linkedList.addFirst(i);
        }
        System.out.println(linkedList);
    }
}
