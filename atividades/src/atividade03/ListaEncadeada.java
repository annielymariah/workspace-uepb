package atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {
    public Integer dado;
    public ListaEncadeada proximo;

    public ListaEncadeada() {
    }

    public ListaEncadeada(Integer novodado) {
        this.dado = novodado;
    }

    public boolean isEmpty() {
        if (dado == null) {
            return true;
        } else {
            return false;
        }
    }

    public Integer size() {
        if (isEmpty()) {
            return 0;
        } else {
            return 1 + proximo.size();
        }
    }

    public Integer search(Integer element) throws Exception {
        if (isEmpty()) {
            throw new Exception("Valor não encontrado");
        } else {
            if (dado == element) {
                return dado;
            } else {
                return proximo.search(element);
            }
        }

    }

    public void insert(Integer element) {
        ListaEncadeada novoNo = new ListaEncadeada(element);
        novoNo.dado = dado;
        novoNo.proximo = proximo;

        this.dado = element;
        this.proximo = novoNo;
    }

    public void remove(Integer element) {
        if (isEmpty()) {

            return;
        }
        if (dado == element) {

            dado = proximo.dado;
            proximo = proximo.proximo;
        } else {

            proximo.remove(element);
        }
    }

    public Integer[] toArray() {
        if (isEmpty()) {
            return new Integer[0];
        } else {
            Integer[] resultados = new Integer[size()];
            auxtoArray(resultados, 0, this);
            return resultados;
        }
    }

    public void auxtoArray(Integer[] vetor, int index, ListaEncadeada no) {
        if (!no.isEmpty()) {
            vetor[index] = no.dado;
            if (no.proximo != null) {
                auxtoArray(vetor, index + 1, no.proximo);
            }
        }
    }

    public String toString() {
        return "{" +
                " dado='" + dado + "'" +
                ", prox='" + proximo + "'" +
                "}";
    }

}