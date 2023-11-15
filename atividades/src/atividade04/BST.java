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
		Integer resultado = searchRecursivo(raiz, element);
		if (resultado == null) {
			throw new Exception("Elemento não encontrado na BST.");
		}
		return resultado;
	}

	private Integer searchRecursivo(No raiz, Integer element) {
		if (raiz == null || raiz.data.equals(element)) {
			return (raiz != null) ? raiz.data : null;
		}

		if (element < raiz.data) {
			return searchRecursivo(raiz.esquerda, element);
		}

		return searchRecursivo(raiz.direita, element);
	}

	public int[] preOrder() {
		int[] resultados = new int[tamanho(raiz)];
		preOrderRecursive(raiz, resultados, new Indice());
		return resultados;
	}

	public void preOrderRecursive(No raiz, int[] result, Indice indice) {
		if (raiz != null) {

			result[indice.valor++] = raiz.data;
			preOrderRecursive(raiz.esquerda, result, indice);
			preOrderRecursive(raiz.direita, result, indice);

		}

	}

	public int[] order() {
		int[] resultados = new int[tamanho(raiz)];
		orderRecursive(raiz, resultados, new Indice());
		return resultados;
	}

	private void orderRecursive(No raiz, int[] result, Indice indice) {
		if (raiz != null) {

			orderRecursive(raiz.esquerda, result, indice);
			result[indice.valor++] = raiz.data;
			orderRecursive(raiz.direita, result, indice);

		}

	}

	public int[] postOrder() {
		int[] resultados = new int[tamanho(raiz)];
		postOrderRecursive(raiz, resultados, new Indice());
		return resultados;
	}

	public void postOrderRecursive(No raiz, int[] result, Indice indice) {
		if (raiz != null) {
			postOrderRecursive(raiz.esquerda, result, indice);
			postOrderRecursive(raiz.direita, result, indice);
			result[indice.valor++] = raiz.data;

		}
	}

	public boolean isComplete() {
		int indice = 0;
		return isCompleteRecursive(raiz, indice, tamanho(raiz));
	}

	private boolean isCompleteRecursive(No raiz, int indice, int tamanho) {
		if (raiz == null) {
			return true;
		}

		if (indice >= tamanho) {
			return false;
		}

		return (isCompleteRecursive(raiz.esquerda, 2 * indice + 1, tamanho) &&
				isCompleteRecursive(raiz.direita, 2 * indice + 2, tamanho));
	}

	public int tamanho(No raiz) {
		if (raiz == null) {
			return 0;
		}
		return 1 + tamanho(raiz.esquerda) + tamanho(raiz.direita);
	}

	public int height(No raiz) {
		if (raiz != null) {
			int hdireita, hesquerda = 0;

			hesquerda = height(raiz.esquerda);
			hdireita = height(raiz.direita);

			if (hdireita > hesquerda)
				return hdireita + 1;

			return hesquerda + 1;
		}
		return 0;
	}

	public static class Indice {
		int valor;
	}
}
