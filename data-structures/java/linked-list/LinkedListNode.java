package data_structures;

public class LinkedListNode<T>{
    public T value;
    public LinkedListNode<T> next;

    public LinkedListNode(T value) {
        this.value = value;
        this.next = null;
    }
    public LinkedListNode<T> getNext() {
        return this.next;
    }
}
