package data_structures;


public class LinkedList<T>  {

    private LinkedListNode<T> head;
    private int listCount;

    public LinkedList(T initialValue){
        this.head = new LinkedListNode<T>(initialValue);
        this.listCount = 1;
    }


    public LinkedListNode<T> getHead(){
        return this.head;
    }

    public LinkedListNode<T> getNodeAt(int index){
        if (index < 0 || index >= this.listCount) {
            return null;
        }

        LinkedListNode<T> current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public T getValueAt(int index){
        LinkedListNode<T> current = this.head;
        for(int i =0; i< this.listCount; i++){
            if(index == i){
                return current.value;
            } else {
                current = current.next;
            }
        }
        return null;
    }

    public int size(){
        return this.listCount;
    }

    public LinkedListNode<T> getTail(){
        LinkedListNode<T> currentNode = this.head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public LinkedListNode<T> append (T value){
        LinkedListNode<T> newNode = new LinkedListNode<>(value);
        LinkedListNode<T> currentNode = this.getTail();
        currentNode.next = newNode;
        this.listCount++;
        return newNode;
    }

    public LinkedListNode<T> removeAt (int index){
        if (index >= this.listCount) {
            return null;
        }
        LinkedListNode<T> removedNode;

        if (index == 0) {
            removedNode = this.head;
            this.head = this.head.next;
        } else {
            LinkedListNode<T> previousNode = getNodeAt(index - 1);
            removedNode = previousNode.next;
            previousNode.next = removedNode.next;
        }

        this.listCount--;
        return removedNode;
    }

    @Override
    public String toString(){
        LinkedListNode<T> current = head;
        StringBuilder result = new StringBuilder();

        while (current != null) {
            result.append(current.value).append(" -> ");
            current = current.next;
        }
        result.append("null");
        return result.toString();
    }
}
