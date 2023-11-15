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
		int[] resultados = new int[quantNo(raiz)];
		preOrderRecursive(raiz, resultados,new Indice());
		return resultados;
	}

	public void preOrderRecursive(No raiz, int[] result,Indice indice) {
		if(raiz != null) {

			result[indice.valor++] = raiz.data;
			System.out.println(raiz.data);
			preOrderRecursive(raiz.esquerda, result, indice);
			preOrderRecursive(raiz.direita, result, indice);

		}

	}

	public int[] order() {
		int[] resultados = new int[quantNo(raiz)];
		orderRecursive(raiz, resultados,new Indice());
		return resultados;
	}

	private void orderRecursive(No raiz, int[] result, Indice indice) {
				if(raiz != null) {

					orderRecursive(raiz.esquerda, result, indice);
					result[indice.valor++] = raiz.data;
					System.out.println(raiz.data);
					orderRecursive(raiz.direita, result, indice);

		}

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
			result[indice.valor++] = raiz.data;
			System.out.println(raiz.data);

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
		int valor;
	}
}
