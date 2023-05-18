public class DoublyLinkedListt<T> {
    private static class Node<T>{
        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(T value, Node<T> next, Node<T> prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }

        public T getValue(){
            return value;
        }
        public Node<T> getNext(){
            return next;
        }
        public Node<T> getPrev(){
            return prev;
        }
        public void setNext(Node<T> next){
            this.next = next;
        }
        public void setPrev(Node<T> prev){
            this.prev = prev;
        }
    }

    private Node<T> header;
    private Node<T> trailer;
    private int size;

    public DoublyLinkedListt(){
        this.size = 0;
        header = new Node<>(null,null,null);
        // How give null value - for "int value" in header Node
        // So I dont need it, becase now I use Generics
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public T getFirstNode(){
        if(isEmpty()){
            return null;
        }
        return header.getNext().getValue();
    }
    public T getLastNode(){
        if(isEmpty()){
            return null;
        }
        return trailer.getPrev().getValue();
    }
    private void addBetween(T value, Node<T> aheadNewest, Node<T> behindNewest){
        Node<T> newest = new Node<>(value, aheadNewest,behindNewest);
        // wrong down
        aheadNewest.setNext(newest);
        behindNewest.setPrev(newest);
        size++;
    }
    private void remove(Node<T> nodeForRemove){
        Node<T> aheadRemovable = nodeForRemove.getNext();
        Node<T> behindRemovable = nodeForRemove.getPrev();
    }
    

}
