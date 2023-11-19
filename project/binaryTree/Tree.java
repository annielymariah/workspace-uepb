package binaryTree;

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
                current = current.getRight(); // Começa pela direita, depois vai para a esquerda, se não dá problema
            } else {
                current = current.getLeft();
            }
        }
        System.out.println("false");
    }

    public void remove(T element) {
        root = removeElement(root, element);
    }

    private Node<T> removeElement(Node<T> current, T element) {
        if (current == null) {
            return null;
        }

        int comparison = element.compareTo(current.getData());

        if (comparison < 0) {
            // Elemento a ser removido está na subárvore esquerda
            current.setLeft(removeElement(current.getLeft(), element));
        } else if (comparison > 0) {
            // Elemento a ser removido está na subárvore direita
            current.setRight(removeElement(current.getRight(), element));
        }

        else {

            // Elemento encontrado, realizar a remoção

            if (current.getLeft() == null) { // Verifica se não há filhos a esqueda, retorna o elemento
                return current.getRight();
            } else if (current.getRight() == null) { // Verifica se não há filhos a direita, retorna o elemento
                return current.getLeft();
            }

            current.setData(findMin(current.getRight()).getData());
            current.setRight(removeElement(current.getRight(), current.getData()));
        }

        return current;
    }

    private Node<T> findMin(Node<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    private Node<T> findMax(Node<T> node) {
        while (node.getRight() != null) {
            node = node.getLeft();
        }
        return node;
    }
}
