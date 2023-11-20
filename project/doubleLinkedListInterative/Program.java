package doubleLinkedListInterative;

public class Program {
    public static void main(String[] args) {

        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
        System.out.print(list.isEmpty());
        list.insert(1);
        list.insert(2);
        list.insertFirst(3);
        list.insertFirst(5);
        list.insertFirst(7);
        list.string();
        System.out.println(list.search(2));

        System.out.println(list.search(9));
        System.out.println(list.size());
        list.remove(2);

        list.string();
        list.removeLast();
        list.string();
        list.removeLast();
        list.string();
        list.removeFirst();
        list.string();
    }

}
