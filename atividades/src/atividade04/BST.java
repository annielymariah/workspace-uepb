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

	public No insertRecursive(No root, Integer element) {
		if (raiz == null) {
			raiz = new No(element);
			return raiz;
		}

		if (element < raiz.data) {
			raiz.esquerda = insertRecursive(raiz.esquerda, element);
		} else if (element > root.data) {
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
		int[] placeholder = new int[] { 1, 2, 3 }; // Substitua pelos valores desejados
		return placeholder;
	}

	private void postOrderRecursive(No raiz, int[] result) {

	}

	public boolean isComplete() {
		return true;
	}

	private boolean isCompleteRecursive(No raiz) {
		return false;
	}

}
