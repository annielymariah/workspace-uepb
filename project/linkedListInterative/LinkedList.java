package linkedListInterative;

public class LinkedList<T> implements LinkedList_IF<T> {
    
        private Node<T> head = null;
        private Node<T> tail;


    public boolean isEmpty(){
        if (head == null){
            return true; 
        }
        return false;   
    }

    public int size(){
        Node<T> aux = head;
        int count = 0;

        while (aux != null){
            aux = aux.next;
            count++;
        }
        return count;
    }

        public boolean search (T element){
            Node<T> aux = head;

            while (aux != null && aux.data != element){
                aux = aux.next;
            }
            if (aux == null){
                return false;
            }
            return true;
        }

    public void insert(T element){
        Node<T> node = new Node<T>();
        node.setData(element);

        if (head == null){
            this.head = node;
        }
        else {
            this.tail.setNext(node);
        }
        this.tail = node;
    }

    public void remove(T element) {
        if (head != null && head.data.equals(element)) {
            head = head.next;
            return;
        }
    
        Node<T> current = head;
        Node<T> previous = null;
    
        while (current != null && !current.data.equals(element)) {
            previous = current;
            current = current.next;
        }
    
        if (current != null) {
            previous.next = current.next;
        }
    }

    @Override
    public String toString() {
        return "LinkedList [head=" + head + "]";
    }
}
