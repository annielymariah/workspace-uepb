package atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {

    public Integer dado;
    public ListaEncadeada prox;

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
            return 1 + prox.size();

        }
    }

    public Integer search(Integer element) throws Exception {
        if (isEmpty()) {
            throw new Exception("Valor não encontrado");
        } else {
            if (dado == element) {
                return dado;
            } else {
                return prox.search(element);
            }
        }

    }

    public void insert(Integer element) {

        if (isEmpty()) {
            dado = element;
        }
        ListaEncadeada novalista = new ListaEncadeada();
        novalista.dado = element;
        novalista.prox = this;
        this.prox = novalista;

    }

    public void remove(Integer element) {
        if (isEmpty()) {

        } else {
            if (dado == element) {
                dado = prox.dado;
                prox = prox.prox;
            }
        }

    }

    public Integer[] toArray() {
        Integer[] resultados = new Integer[size()];
        auxtoArray(resultados, 0, this);
        return resultados;

    }

    public void auxtoArray(Integer[] vetor, int index, ListaEncadeada no) {
        if (!no.isEmpty()) {
            vetor[index] = no.dado;
            if (no.prox != null) {
                auxtoArray(vetor, index + 1, no.prox);
            }
        }
    }

}
