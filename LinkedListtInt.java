public class DoublyLinkedListt {
    private static class Node{
        private int value;
        private Node next;
        private Node prev;

        public Node(int value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public int getValue(){
            return value;
        }
        public Node getNext(){
            return next;
        }
        public Node getPrev(){
            return prev;
        }
        public void setNext(Node next){
            this.next = next;
        }
        public void setPrev(Node prev){
            this.prev = prev;
        }
    }

    private Node header;
    private Node trailer;
    private int size;

    public DoublyLinkedListt(){
        this.size = 0;
        header = new Node(0,null,null);
        // How give null value - for "int value" in header Node
        trailer = new Node(0, header, null);
        header.setNext(trailer);
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int getFirstNode(){
        if(isEmpty()){
            return -1;
        }
        return header.getNext().getValue();
    }
    public int getLastNode(){
        if(isEmpty()){
            return -1;
        }
        return trailer.getPrev().getValue();
    }
    private void addBetween(int value, Node aheadNewest, Node behindNewest){
        Node newest = new Node(value,aheadNewest,behindNewest);
        // wrong down
        aheadNewest.setNext(newest);
        behindNewest.setPrev(newest);
        size++;
    }
    private void remove(Node nodeForRemove){
        Node aheadRemovable = nodeForRemove.getNext();
        Node behindRemovable = nodeForRemove.getPrev();
        ahe
    }
