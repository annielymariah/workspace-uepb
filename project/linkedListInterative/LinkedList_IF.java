package linkedListInterative;
public interface LinkedList_IF<T> {
    public boolean isEmpty();
    public int size();
    public boolean search (T element);
    public void insert(T element);
    public void remove(T element);
}