package atividade03;


/*
To-Do List:  
construtor de pilha na linha 12 e 13
saber se tem alguma coisa certa nisso aquikkkkkkk
*/

public class FilaComPilhas implements Fila_IF {

    public FilaComPilhas(int capacidade) {
        pilha1 = new PilhaComLista(capacidade);
        pilha2 = new PilhaComLista(capacidade);
    }

    public void enqueue(Integer element) throws Exception {
        if (isFull()) {
            throw new Exception ("A fila está cheia");
        }
        FilaComPilhas.head().push(element);
    }

    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("A fila está vazia.");
        }

        if (pilha2.isEmpty()) {
            transferir_Pilha1_Para_Pilha2();
        }

        return pilha2.pop();

    }

	public int head() throws Exception {
        if (isEmpty()) {
            throw new Exception("A fila está vazia.");
        }

        if (pilha2.isEmpty()) {
            transferir_Pilha1_Para_Pilha2();
        }

        return pilha2.top();
    }

	public boolean isEmpty() {
        return pilha1.isEmpty() && pilha2.isEmpty();
    }

	public boolean isFull() {
       return pilha1.isFull() && pilha2.isFull();
    }

    private void transferir_Pilha1_Para_Pilha2() {
        while (!pilha1.isEmpty()) {
            pilha2.push(pilha1.pop());
        }
    
}
