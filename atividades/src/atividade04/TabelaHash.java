package atividade04;

import java.util.LinkedList;

public class TabelaHash implements TabelaHash_IF {
    private LinkedList<Integer>[] tabela;
    private int tamanho;

    public TabelaHash(int size) {
        this.tamanho = size;
        this.tabela = new LinkedList[size];

        for (int i = 0; i < size; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    private int hash(Integer element) {
        return element % tamanho;
    }

    @Override
    public void insert(Integer element) {
        int index = hash(element);
        tabela[index].addFirst(element);
    }

    @Override
    public void remove(Integer element) throws Exception {
        int index = hash(element);
        if (!tabela[index].remove(element)) {
            throw new Exception("Elemento não encontrado na tabela.");
        }
    }

    @Override
    public int search(Integer element) throws Exception {
        int index = hash(element);
        if (tabela[index].contains(element)) {
            return element;
        } else {
            throw new Exception("Elemento não encontrado na tabela.");
        }
    }

    public String print() {
        String result = "";
        for (int i = 0; i < tamanho; i++) {
            result += i + ": ";

            if (!tabela[i].isEmpty()) {
                result += tabela[i].get(0);
                for (int j = 1; j < tabela[i].size(); j++) {
                    result += ", " + tabela[i].get(j);
                }
            }
            result += "\n";
        }
        return result;
    }
}
