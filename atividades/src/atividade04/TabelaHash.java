package atividade04;
import java.util.LinkedList;

public class TabelaHash implements TabelaHash_IF {
    private LinkedList<Integer>[] tabela;
    private int tamanho;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new LinkedList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    @Override
    public void insert(Integer element) {
        int indice = hash(element);
        tabela[indice].add(element);
    }

    @Override
    public void remove(Integer element) throws Exception {
        int indice = hash(element);
        if (!tabela[indice].remove(element)) {
            throw new Exception("Elemento não encontrado na tabela.");
        }
    }    

    @Override
    public int search(Integer element) throws Exception {
        int indice = hash(element);
        if (tabela[indice].contains(element)) {
            return element;
        } else {
            throw new Exception("Elemento não encontrado na tabela.");
        }
    }

    private int hash(Integer element) {
        return element % tamanho;
    }

    @Override
    public String print() {
        String resultado = "";
        for (int i = 0; i < tamanho; i++) {
            resultado += i + ": ";
            if (!tabela[i].isEmpty()) {
                LinkedList<Integer> reversedList = new LinkedList<>();
                for (int j = tabela[i].size() - 1; j >= 0; j--) {
                    reversedList.add(tabela[i].get(j));
                }
    
                resultado += reversedList.get(0);
                for (int j = 1; j < reversedList.size(); j++) {
                    resultado += ", " + reversedList.get(j);
                }
            }
            resultado += "\n";
        }
        return resultado;
    }
}
