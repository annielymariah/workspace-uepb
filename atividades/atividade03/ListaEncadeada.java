package atividade03;

public class ListaEncadeada implements ListaEncadeada_IF {

    public Integer dado;
    public ListaEncadeada prox;

    public boolean isEmpty(){
        if (dado == null){
            return true;
        }
        else{
            return false;
        }
    }


	public Integer size(){
        if(isEmpty()){
            return 0;
        }
        else{
            return 1+prox.size();

        }
    }
	public Integer search(Integer element) throws Exception{
        if(isEmpty()){
            throw new Exception("Valor não encontrado");
        }
        else{
            if (dado == element){
                return dado;
            }
            else{
                return prox.search(element);
            }
        }

    }

    public void insert(Integer element){}


	public void remove(Integer element){
            if(isEmpty()){
            
        }
        else{
            if(dado == element){
                dado = prox.dado;
                prox = prox.prox;
            }
        }

    }
	public Integer[] toArray() {
 

    }


    
}
