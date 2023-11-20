package doubleLinkedListInterative;

public class DoubleLinkedList<T> implements DoubleLinkedList_IF<T> {

    protected Node<T> head = null;
    protected Node<T> tail = null;

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        Node<T> auxHead = this.head;
        Node<T> auxTail = this.tail;

        while (auxHead != null && auxTail != null && auxHead != auxTail) {
            auxHead = auxHead.getNext();
            count++;
            auxTail = auxTail.getPrevious();
            count++;
        }
        if (auxHead != null && auxTail != null && auxHead == auxTail) {
            count++;
        }
        return count;
    }

    public T search(T element) {
        Node<T> auxHead = this.head;
        Node<T> auxTail = this.tail;

        if (element != null) {
            while (auxHead != null && auxTail != null && auxHead != auxTail && !auxHead.getData().equals(element)
                    && !auxTail.getData().equals(element)) {
                auxHead = auxHead.getNext();
                auxTail = auxTail.getPrevious();
            }
            if (auxHead != null && auxHead.getData().equals(element)) {
                return auxHead.getData();
            }
            if (auxTail != null && auxTail.getData().equals(element)) {
                return auxTail.getData();
            }
        }
        return null;
    }

    public void insert(T element) {
        Node<T> node = new Node<>(element);

        if (element != null) {
            if (isEmpty()) {
                this.head = node;
                this.tail = head;
            } else {
                this.tail.setNext(node);
                node.setPrevious(this.tail);
                this.tail = node;
            }
        }
    }

    public void insertFirst(T element) {
        Node<T> node = new Node<>(element);

        if (element != null) {
            if (isEmpty()) {
                this.head = node;
                this.tail = head;
            } else {
                this.head.setPrevious(node);
                node.setNext(this.head);
                this.head = node;
            }
        }
    }

    public void remove(T element) {

        Node<T> auxHead = this.head;
        Node<T> auxTail = this.tail;
        if (element != null && auxHead != null && auxTail != null) {

            if (auxHead.getData().equals(element)) {
                this.head = auxHead.getNext();

                if (this.head != null) { // Faltou isso - Insere um previous ausente
                    this.head.setPrevious(null);
                } else {
                    this.tail = null; // Se a lista ficar vazia após a remoção
                }
            } else if (auxTail.getData().equals(element)) {
                this.tail = auxTail.getPrevious();
                if (this.tail != null) { // Faltou isso - Insere um next ausente
                    this.tail.setNext(null);
                } else {
                    this.head = null; // Se a lista ficar vazia após a remoção
                }
            } else {
                while (auxHead != null && auxTail != null && auxHead.getData() != element
                        && auxTail.getData() != element && auxHead != auxTail) {
                    auxHead = auxHead.getNext();
                    auxTail = auxTail.getPrevious();
                }

                if (auxHead != null && auxHead.getData().equals(element)) {
                    auxHead.setPrevious(auxHead.getNext());
                    this.head = auxHead;
                }
                if (auxTail != null && auxTail.getData().equals(element)) {
                    auxTail.setNext(auxTail.getPrevious());
                    this.tail = auxTail;
                }
            }
        }
    }

    public void removeLast() {

        if (this.tail != null) {
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            }

            Node<T> node = this.tail.getPrevious();
            node.setNext(null);
            this.tail = node;
        }
    }

    public void removeFirst() {

        if(this.head != null){
            if (this.head == this.tail) {
                this.head = null;
                this.tail = null;
            }
        }

        Node<T> node = this.head.getNext();
        node.setPrevious(null);
        this.head = node;
    }

    public T[] toArray() {
        // Implemente a conversão para array conforme necessário
        return null;
    }

    public void string() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}

