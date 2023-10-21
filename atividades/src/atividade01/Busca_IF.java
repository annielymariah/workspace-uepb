package atividade01;

public interface Busca_IF {

    int[] geraVetorNumericoOrdenado(int tamanho);

    boolean buscaLinear_iterativa(int[] numeros, int k);

    boolean buscaLinear_recursiva(int[] numeros, int k);

    boolean buscaLinear_iterativa_duasPontas(int[] numeros, int k);

    boolean buscaBinaria_iterativa(int[] numeros, int k);

    boolean buscaBinaria_recursiva(int[] numeros, int k);

}