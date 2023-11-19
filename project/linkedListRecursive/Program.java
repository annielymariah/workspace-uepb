package linkedListRecursive;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int select;

        LinkedList<Integer> list = new LinkedList<>();

        System.out.println("1 - Verificar lista vazia: public boolean isEmpty();\r\n" + //
                "2 - Verificar tamanho da lista: public int size();\r\n" + //
                "3 - Procurar elemento: public T search (T element);\r\n" + //
                "4 - Inserir elemento: public void insert(T element);\r\n" + //
                "5 - Remover elemento: public void remove(T element);\r\n" + //
                "6 - Visualizar lista: public void string();\r\n" + //
                "-1 - Sair;");

        do {
            select = sc.nextInt();

            switch (select) {
                case 1: {
                    System.out.println(list.isEmpty());
                    break;
                }
                case 2: {
                    System.out.println("Tamanho da lista: " + list.size());
                    break;
                }
                case 3: {
                    System.out.print("Insira o valor que deseja buscar: ");
                    int element = sc.nextInt();
                    System.out.println(list.search(element));
                    break;
                }
                case 4: {
                    System.out.print(
                            "Insira os valores que deseja adicionar, separando-os por ENTER (0 para finalizar): ");
                    int element = sc.nextInt();
                    while (element != 0) {
                        list.insert(element);
                        element = sc.nextInt();
                    }
                    System.out.println(list);
                    break;
                }
                case 5: {
                    System.out.print("Insira o valor que deseja remover: ");
                    int element = sc.nextInt();
                    list.remove(element);
                    break;
                }
                case 6: {
                    list.string();
                    break;
                }
                default: {
                    System.out.println("Insire o valor -1 para sair.");
                }

            }

        } while (select != -1);
        sc.close();
    }
}
