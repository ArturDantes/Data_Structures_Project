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
    public void addFirst(T nodeToAdd){
        addBetween(nodeToAdd, header, header.getNext());
    }
    public void addLast(T nodeToAdd){
        addBetween(nodeToAdd, trailer.getPrev(), trailer);
    }
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        return remove(header.getNext());
    }
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        return remove(trailer.getPrev());
    }
    // predecessor --> Node --> successor
    private void addBetween(T value, Node<T> predecessor, Node<T> successor){
        Node<T> newest = new Node<>(value, predecessor,successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    private T remove(Node<T> nodeForRemove){
        Node<T> predecessor = nodeForRemove.getNext();
        Node<T> successor = nodeForRemove.getPrev();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return nodeForRemove.getValue();
    }
}
