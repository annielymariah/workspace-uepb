package binaryTree;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> binaryTree = new Tree<>();

        binaryTree.insert(10);
        binaryTree.insert(8);
        binaryTree.insert(5);
        binaryTree.insert(9);
        binaryTree.insert(7);
        binaryTree.insert(18);
        binaryTree.insert(13);
        binaryTree.insert(20);

        System.out.print("Em-ordem: ");
        binaryTree.order(0);

        System.out.print("\nPré-ordem: ");
        binaryTree.order(-1);

        System.out.print("\nPós-ordem: ");
        binaryTree.order(1);
        binaryTree.search(1);
        binaryTree.remove(18);
        System.out.print("Em-ordem: ");
        binaryTree.order(0);
    }

}
