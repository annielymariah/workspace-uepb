package doubleLinkedListInterative;

public interface DoubleLinkedList_IF<T>{
public boolean isEmpty();
public int size();
public T search(T element);
public void insert(T element);
public void remove(T element);
public T[] toArray();
public void insertFirst(T element);
public void removeFirst();
public void removeLast();
}
