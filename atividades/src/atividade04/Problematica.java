package atividade04;
import java.util.Random;
public class Problematica {

    public static void main(String[] args) {
        BST arvore = new BST();


        arvore.insert(27);
        arvore.insert(31);
        arvore.insert(40);
        arvore.insert(41);

        System.out.println("Percurso Pós-Ordem:");
        for (int value : arvore.postOrder()) {
            System.out.print(value + " ");
        }


    }
}