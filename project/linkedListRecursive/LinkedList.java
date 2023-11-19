package linkedListRecursive;

public class LinkedList<T> {

    private T data = null;
    private LinkedList<T> next = null;

    public boolean isEmpty() {
        return data == null;
    }

    public int size() {
        return sizeAux(0);
    }

    private int sizeAux(int element) {
        if (isEmpty()) {
            return element;
        }
        return next.sizeAux(element++);
    }

    public boolean search(T element) {
        if (isEmpty()) {
            return false;
        } else if (data.equals(element)) {
            return true;
        }
        return next.search(element);
    }

    public void insert(T element) {
        if (element != null) {
            if (isEmpty()) {
                this.data = element;
                this.next = new LinkedList<>();
            } else {
                next.insert(element);
            }
        }
    }

    public void remove(T element) {
        if (element != null) {
            if (!isEmpty()) {
                if (data.equals(element)) {
                    this.data = next.data;
                    this.next = next.next;
                    return;
                } else {
                    LinkedList<T> aux = new LinkedList<>();
                    aux = next.next;
                    removeAux(element, next, aux);
                }
            }
            return;
        }

    }

    public void removeAux(T element, LinkedList<T> previous, LinkedList<T> current) {

        if (current != null) {

            if (current.data.equals(element)) {
                previous.next = current.next;
                return;
            }

            previous = current;
            current = current.next;
            removeAux(element, previous, current);
        }
        return;
    }

    public void string() {
        if (!isEmpty()) {
            System.out.print(data + " ");
            next.string();
        }
    }

}
