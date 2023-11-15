package atividade04;

public class BST implements BST_IF {

	public No raiz;

	public class No {
		Integer data;
		No esquerda, direita;

		public No(Integer item) {
			data = item;
			esquerda = direita = null;
		}
	}

	public void insert(Integer element) {
		raiz = insertRecursive(raiz, element);
	}

	public No insertRecursive(No raiz, Integer element) {
		if (raiz == null) {
			raiz = new No(element);
			return raiz;
		}

		if (element < raiz.data) {
			raiz.esquerda = insertRecursive(raiz.esquerda, element);
		} else if (element > raiz.data) {
			raiz.direita = insertRecursive(raiz.direita, element);
		}

		return raiz;
	}

	public Integer search(Integer element) throws Exception {

		return 0;
	}

	private Integer searchRecursive(No raiz, Integer element) {

		return 0;

	}

	public int[] preOrder() {
		int[] placeholder = new int[] { 1, 2, 3 }; // Substitua pelos valores desejados
		return placeholder;
	}

	private void preOrderRecursive(No raiz, int[] result) {

	}

	public int[] order() {
		int[] placeholder = new int[] { 1, 2, 3 }; // Substitua pelos valores desejados
		return placeholder;
	}

	private void orderRecursive(No raiz, int[] result) {

	}


	public int[] postOrder() {
		int[] resultados = new int[quantNo(raiz)];
		postOrderRecursive(raiz, resultados,new Indice());
		return resultados;
	}

	public void postOrderRecursive(No raiz, int[] result, Indice indice) {
		if(raiz != null) {
			postOrderRecursive(raiz.esquerda, result, indice);
			postOrderRecursive(raiz.direita, result, indice);
			if (indice.valor > 0) {
				result[indice.valor--] = raiz.data;
				indice.valor--; // Decrementa apenas se o índice for maior que zero
			} else {
				// Trate o caso em que o índice já é zero ou negativo, se necessário
				// Isso pode ocorrer se houver mais elementos do que o valor inicial de Indice
				// Por exemplo, se a árvore for modificada após a criação de Indice
			}
		}
	}

	public boolean isComplete() {
		return true;
	}

	private boolean isCompleteRecursive(No raiz) {
		return false;
	}

	public int quantNo(No raiz) {
		if (raiz == null) {
			return 0;
		}
		return 1 + quantNo(raiz.esquerda) + quantNo(raiz.direita);
	}

	public static void indexarValoresReverso(int[] vetor, int[] valores, int indice) {
		if (indice >= 0) {
			vetor[indice] = valores[indice];
			indexarValoresReverso(vetor, valores, indice - 1);
		}
	}


	public static class Indice {
		BST arvore = new BST();
		int valor = arvore.quantNo(arvore.raiz);
	}
}
