package atividade04;

public class No {
    public Integer data;
    public No esquerda;
    public No direita;

    public No(Integer novaData){
        this.data = novaData;
        this.esquerda = null;
        this.direita = null;
    }
    
}
