//Equipe: Anniely Mariah, Gabriel Menezes, João Pedro Souza.
// Turno: Manhã
//  Projeto: algoritmos de busca em JAVA e suas complexidades.

package assignments.atv1;

public class BrincandoComBusca {

    public static void main(String[] args) {
        //int i = 1;
        //while (i < 50000) {

            Busca_IF b = new Busca();
            final int numeroParaBuscar = 10;

//            System.out.print("\nIndex:" + i);

            final int[] vetor1000 = b.geraVetorNumericoOrdenado(100000);

            long antes, depois;

            antes = System.nanoTime();
            b.buscaLinear_iterativa(vetor1000, numeroParaBuscar);
            depois = System.nanoTime();
            System.out.println("buscaLinear_iterativa:\t" + (depois - antes));

            antes = System.nanoTime();
            b.buscaLinear_recursiva(vetor1000, numeroParaBuscar);
            depois = System.nanoTime();
            System.out.println("buscaLinear_recursiva:\t" + (depois - antes));

            antes = System.nanoTime();
            b.buscaLinear_iterativa_duasPontas(vetor1000, numeroParaBuscar);
            depois = System.nanoTime();
            System.out.println("buscaLinear_iterativa2:\t" + (depois - antes));

            antes = System.nanoTime();
            b.buscaBinaria_iterativa(vetor1000, numeroParaBuscar);
            depois = System.nanoTime();
            System.out.println("buscaBinaria_iterativa:\t" + (depois - antes));

            antes = System.nanoTime();
            b.buscaBinaria_recursiva(vetor1000, numeroParaBuscar);
            depois = System.nanoTime();
            System.out.println("buscaBinaria_recursiva:\t" + (depois - antes));
//            i++;
        }
    //}
}