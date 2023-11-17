package BinaryTree;

public class Tree<T extends Comparable<T>> {

    private Node<T> root;

    public Tree() {
        this.root = null;
    }

    public Node<T> getRoot() {
        return root;
    }
    
    public void insert(T element) {
        Node<T> node = new Node<>(element);

        if (root == null) {
            this.root = node;
        } else {
            Node<T> current = this.root;
            while (true) {
                if (node.getData().compareTo(current.getData()) == -1) {
                    // 0 é igual
                    // 1 é maior
                    // -1 é menor
                    if (current.getLeft() != null) {
                        current = current.getLeft();
                    } else {
                        current.setLeft(node);
                        break;
                    }
                } else {
                    if (current.getRight() != null) {
                        current = current.getRight();
                    } else {
                        current.setRight(node);
                        break;
                    }
                }
            }
        }
    }

    public void order(int i) {
        switch (i) {
            case 0:
                inOrder(this.root);
                break;
            case 1:
                postOrder(this.root);
                break;
            case -1:
                preOrder(this.root);
                break;
            default:
                System.out.println("Opção inválida");
        }
    }

    public void inOrder(Node<T> root) {
        if (root != null) { // Parametro de parada, chegada em uma folha
            inOrder(root.getLeft());
            System.out.print(root.getData() + " ");
            inOrder(root.getRight());
        }
    }

    public void postOrder(Node<T> root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.print(root.getData() + " ");
        }
    }

    public void preOrder(Node<T> root) {
        if (root != null) {
            System.out.print(root.getData() + " ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public void search(T element) {
        Node<T> current = this.root;
    
        while (current != null) {
            if (current.getData().equals(element)) {
                System.out.println("true");
                return;
            } else if (current.getData().compareTo(element) < 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
    
        System.out.println("false");
    }

    // public boolean remove(T element) {
    //     Node<T> current = this.root;
        
    //     Node<T> previous = null;

    //     if (current == null) {
    //         return false;
    //     }

    //     while (current != null) {
    //         if (current.data.equals(element)) {
    //             break;
    //         } else if (current.data.compareTo(element) == -1) {
    //             previous = current;
    //             current = current.getLeft();
    //         } else {
    //             previous = current;
    //             current = current.getRight();
    //         }
    //     }

    //     if (current.getLeft().equals(null) && current.getRight().equals(null)) { // Não possuí filhos
    //         if (current.getData().compareTo(previous.getData()) == 1) {
    //             previous.setRight(null);
    //         }
    //         previous.setLeft(null);

    //     } else if (current.getLeft() != null) { // Possuí filho a esquerda
    //         current = current.getLeft();
    //         if (current.getData().compareTo(previous.getData()) == 1) {
    //             previous.setRight(current);
    //         }
    //         previous.setLeft(current);

    //     } else if (current.getRight() != null) { // Possuí filho a direita
    //         current = current.getRight();
    //         if (current.getData().compareTo(previous.getData()) == 1) {
    //             previous.setRight(current);
    //         }
    //         previous.setLeft(current);

    //     } else { // Possuí ambos os filhos
    //         if (current.getData().compareTo(previous.getData()) == 1) {
    //             previous.setRight(current);
    //         }
    //         previous.setLeft(current);
    //     }
    //     return true;
    // }

}
