package atividade03;

public class PilhaComLista implements Pilha_IF {

private ListaEncadeada array;

    public Integer capacity = 10;
    public Integer top = 0; // Resolver depois
    
    public PilhaComLista() {
        this.array = new ListaEncadeada();
    }


    public void push(Integer element) throws Exception {
        if (isFull()) {
            throw new Exception("A pilha está cheia");
        }
        else {  
            array.insert(element);
        }
    }

    public Integer pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("A pilha está vazia");
        }
        else {
            top();
            array.remove(top());
            return 1;
        }
    }

    public Integer top() throws Exception {
        if (isEmpty()) {
            throw new Exception("A pilha está vazia");
        }
        else {
            top();
            array.search(top); 
            return 1;
        }
    } // Esperar Gabriel

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public boolean isFull() {
        return array.size() > capacity;
    }
}