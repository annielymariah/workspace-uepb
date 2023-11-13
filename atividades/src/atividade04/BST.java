package atividade04;
import java.io.*;   
import java.util.*; 

public class BST implements BST_IF{
    
	public No raiz;

	public BST(){
		this.raiz = null;
	}

	public void insert(Integer element){
		No novoNo = new No(); // cria um novo Nó
		novoNo.data = element; // atribui o valor recebido ao item de dados do 
	
		if (raiz == null){ 
			raiz = novoNo;
		}

		else  { // se nao for a raiz
		  No atual = raiz;
		  while(true) {
			if (element < atual.data) { // ir para esquerda
			  atual = ;
			  if (atual == null) {
				anterior.esq = novo;
				return;
			  } 
			}  // fim da condição ir a esquerda
			else { // ir para direita
			   atual = atual.dir;
			   if (atual == null) {
				 anterior.dir = novo;
				 return;
			   }
			} // fim da condição ir a direita
		  } // fim do laço while
		}



	}
	public Integer search(Integer element) throws Exception{
		return 0;

	}
	public int[] preOrder(){

		int[] placeholder = new int[]{1, 2, 3}; // Substitua pelos valores desejados
        return placeholder;



	}
	public int[] order(){

		int[] placeholder = new int[]{1, 2, 3}; // Substitua pelos valores desejados
        return placeholder;

	}
	public int[] postOrder(){

		int[] placeholder = new int[]{1, 2, 3}; // Substitua pelos valores desejados
        return placeholder;


	}
	public boolean isComplete(){
		return true;
	}

    
}