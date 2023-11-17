package BinaryTree;

public class Node<T> {
    protected T data; 
    protected Node<T> left;
    protected Node<T> right;
    
    public Node(){} 

    public Node(T data){
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public Node<T> getLeft() {
        return left;
    }
    public void setLeft(Node<T> left) {
        this.left = left;
    }
    public Node<T> getRight() {
        return right;
    }
    public void setRight(Node<T> right) {
        this.right = right;
    }
}
