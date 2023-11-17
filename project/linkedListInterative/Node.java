package linkedListInterative;

public class Node<T> {

    protected T data; // Declaração de nó
    protected Node<T> next; // A referência da alocação do próximo nó

    // Construtores
    
    public Node(){} 
    
    public Node(T data, Node<T> next){
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean isNILL() { 
        return (this.data == null);
    } //  Não me pergunte

        @Override
    public String toString() {
        return "Node [data=" + data + ", next=" + next + "]";
    }
}
