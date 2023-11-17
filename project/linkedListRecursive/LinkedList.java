package linkedListRecursive;

public class LinkedList<T> {

    private Node<T> data = null;

    public boolean isEmpty() {
        return data == null;
    }

    public int size() {
        return sizeAux(data);
    }

    private int sizeAux(Node<T> current) {
        if (current == null) {
            return 0;
        }
        return 1 + sizeAux(current.next);
    }

    public boolean search(T element) {
        return searchAux(data, element);
    }

    private boolean searchAux(Node<T> current, T element) {
        if (current == null) {
            return false;
        }
        if (current.data.equals(element)) {
            return true;
        }
        return searchAux(current.next, element);
    }

    public void insert(T element) {
        data = insertAux(data, element);
    }

    private Node<T> insertAux(Node<T> current, T element) {
        if (current == null) {
            Node<T> newNode = new Node<>();
            newNode.setData(element);
            return newNode;
        }
        current.next = insertAux(current.next, element);
        return current;
    }

    public void remove(T element) {
        data = removeAux(data, element);
    }

    private Node<T> removeAux(Node<T> current, T element) {
        if (current == null) {
            System.out.println("Este elemento não existe.");
            return null;
        }

        if (current.data.equals(element)) {
            return current.next;
        }

        current.next = removeAux(current.next, element);
        return current;
    }

    @Override
    public String toString() {
        return "LinkedList [root=" + data + "]";
    }
}


// package linkedListRecursive;

// public class LinkedList<T> {

//     private Node<T> head = null;
//     private Node<T> tail;

//     public boolean isEmpty() {
//         if (head == null) {
//             return true;
//         }
//         return false;
//     }

//     public int size() {
//         return sizeAux(0, head);
//     }

//     private int sizeAux(int size, Node<T> list) {
//         if (list != null) {
//             return sizeAux(size + 1, list.next);
//         }
//         return size;
//     }

//     public boolean search(T element) {
//         Node<T> list = head;
//         return searchAux(list, element);
//     }

//     public boolean searchAux(Node<T> list, T element) {
//         if (list != null && !list.data.equals(element)) {
//             list = list.next;
//             return searchAux(list, element);
//         } else {
//             return list != null; // Retorna true se o elemento for encontrado, caso contrário, false
//         }
//     }

//     public void insert(T element) {
//         Node<T> node = new Node<T>();
//         node.setData(element);

//         if (head == null) {
//             this.head = node;
//         } else {
//             this.tail.setNext(node);
//         }
//         this.tail = node;
//     }

//     public void remove(T element) {
//         if (head != null && head.data.equals(element)) {
//             head = head.next;
//             return;
//         }

//         Node<T> current = head;
//         Node<T> previous = null;

//         removeAux(current, previous, element);
//     }
//     public void removeAux(Node<T> current, Node<T> previous, T element) {
//         if (current != null && !current.data.equals(element)) {
//             previous = current;
//             current = current.next;
//             removeAux(current, previous, element);
//         }
//         else if (current != null) {
//             previous.next = current.next;
//         } 
//         else {
//             System.out.println("Este elemento não existe.");
//         }
//     }

//     @Override
//     public String toString() {
//         return "LinkedList [head=" + head + "]";
//     }
// }
