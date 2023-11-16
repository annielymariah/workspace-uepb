//Equipe: Anniely Mariah, Gabriel Menezes, João Pedro Souza.
// Turno: Manhã
//  Projeto: algoritmos de Ordenação em JAVA e suas complexidades.

package assignments.atv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BrincandoComOrdenacao {

    public static void guardarResultado(long[] results, String fileName) { // Metodo que salva os resultados e medias
                                                                           // dos 50 testes em um .txt, e o coloca na
                                                                           // pasta resultados.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            writer.write("Resultados: ");

            for (int i = 0; i < results.length; i++) {

                writer.write(Long.toString(results[i]));
                writer.write(" ");
            }
            writer.newLine();

            // Média

            long somatoria = 0;

            for (int i = 0; i < results.length; i++) {
                somatoria += results[i];
            }

            long media = somatoria / results.length;

            writer.write("Media: " + media);

            System.out.println("Arquivos criados com sucesso.");

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static void testarVetores(int[] vetorType, String fileName, int selectTest) { // Metodo que realiza os 50
                                                                                         // testes.
        String localSave = "src/atividade02/resultados/";
        final int TAM = 50;
        long[] results = new long[TAM];

        Ordenacao ordenacao = new Ordenacao();

        switch (selectTest) {
            case 0:
                for (int i = 0; i < TAM; i++) {
                    results[i] = ordenacao.bubbleSort(vetorType);
                }
                guardarResultado(results, localSave + fileName + ".txt");
                break;

            case 1:
                for (int i = 0; i < TAM; i++) {
                    results[i] = ordenacao.selectionSort(vetorType);
                }
                guardarResultado(results, localSave + fileName + ".txt");
                break;

            case 2:
                for (int i = 0; i < TAM; i++) {
                    results[i] = ordenacao.insertionSort(vetorType);
                }
                guardarResultado(results, localSave + fileName + ".txt");
                break;

            case 3:
                for (int i = 0; i < TAM; i++) {
                    results[i] = ordenacao.mergeSort(vetorType);
                }
                guardarResultado(results, localSave + fileName + ".txt");
                break;

            case 4:
                for (int i = 0; i < TAM; i++) {
                    results[i] = ordenacao.quickSort(vetorType);
                }
                guardarResultado(results, localSave + fileName + ".txt");
                break;

            case 5:
                for (int i = 0; i < TAM; i++) {
                    results[i] = ordenacao.quickSort_Java(vetorType);
                }
                guardarResultado(results, localSave + fileName + ".txt");
                //
                break;

            case 6:
                for (int i = 0; i < TAM; i++) {
                    results[i] = ordenacao.random_quickSort(vetorType);
                }
                guardarResultado(results, localSave + fileName + ".txt");
                break;

            case 7:
                for (int i = 0; i < TAM; i++) {
                    results[i] = ordenacao.countingSort(vetorType);
                }
                guardarResultado(results, localSave + fileName + ".txt");
                break;

            default:
                System.out.println("Tipo de teste invalido");
        }
    }

    public static void main(String[] args) {

        // Geração de Arrays

        // 5000

        List<Integer> arrayCrescente5k = new ArrayList<>();
        for (int i = 1; i <= 5000; i++) {
            arrayCrescente5k.add(i);
        }

        List<Integer> arrayDecrescente5k = new ArrayList<>();

        for (int i = 5000; i >= 1; i--) {
            arrayDecrescente5k.add(i);

        }
        List<Integer> arrayEmbaralhado5k = new ArrayList<>(arrayCrescente5k);
        Collections.shuffle(arrayEmbaralhado5k);

        // 10000

        List<Integer> arrayCrescente10k = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            arrayCrescente10k.add(i);
        }

        List<Integer> arrayDecrescente10k = new ArrayList<>();
        for (int i = 10000; i >= 1; i--) {
            arrayDecrescente10k.add(i);
        }

        List<Integer> arrayEmbaralhado10k = new ArrayList<>(arrayCrescente10k);
        Collections.shuffle(arrayEmbaralhado10k);

        // 15000

        List<Integer> arrayCrescente15k = new ArrayList<>();
        for (int i = 1; i <= 15000; i++) {
            arrayCrescente15k.add(i);
        }

        List<Integer> arrayDecrescente15k = new ArrayList<>();
        for (int i = 15000; i >= 1; i--) {
            arrayDecrescente15k.add(i);
        }

        List<Integer> arrayEmbaralhado15k = new ArrayList<>(arrayCrescente15k);
        Collections.shuffle(arrayEmbaralhado15k);

        // Sistema de converção

        int[] vetorCrescente5k = Ordenacao.convertArrayListToArray(arrayCrescente5k);
        int[] vetorCrescente10k = Ordenacao.convertArrayListToArray(arrayCrescente10k);
        int[] vetorCrescente15k = Ordenacao.convertArrayListToArray(arrayCrescente15k);

        int[] vetorDecrescente5k = Ordenacao.convertArrayListToArray(arrayDecrescente5k);
        int[] vetorDecrescente10k = Ordenacao.convertArrayListToArray(arrayDecrescente10k);
        int[] vetorDecrescente15k = Ordenacao.convertArrayListToArray(arrayDecrescente15k);

        int[] vetorEmbaralhado5k = Ordenacao.convertArrayListToArray(arrayEmbaralhado5k);
        int[] vetorEmbaralhado10k = Ordenacao.convertArrayListToArray(arrayEmbaralhado10k);
        int[] vetorEmbaralhado15k = Ordenacao.convertArrayListToArray(arrayEmbaralhado15k);

        // Chamada de Testes

        // Bubble Sort

        testarVetores(vetorCrescente5k, "BubbleSort_Crescente5k", 0);
        testarVetores(vetorDecrescente5k, "BubbleSort_Decrescente5k", 0);
        testarVetores(vetorEmbaralhado5k, "BubbleSort_Embaralhado5k", 0);

        testarVetores(vetorCrescente10k, "BubbleSort_Crescente10k", 0);
        testarVetores(vetorDecrescente10k, "BubbleSort_Decrescente10k", 0);
        testarVetores(vetorEmbaralhado10k, "BubbleSort_Embaralhado10k", 0);

        testarVetores(vetorCrescente15k, "BubbleSort_Crescente15k", 0);
        testarVetores(vetorDecrescente15k, "BubbleSort_Decrescente15k", 0);
        testarVetores(vetorEmbaralhado15k, "BubbleSort_Embaralhado15k", 0);

        // Selection Sort

        testarVetores(vetorCrescente5k, "SelectionSort_Crescente5k", 1);
        testarVetores(vetorDecrescente5k, "SelectionSort_Decrescente5k", 1);
        testarVetores(vetorEmbaralhado5k, "SelectionSort_Embaralhado5k", 1);

        testarVetores(vetorCrescente10k, "SelectionSort_Crescente10k", 1);
        testarVetores(vetorDecrescente10k, "SelectionSort_Decrescente10k", 1);
        testarVetores(vetorEmbaralhado10k, "SelectionSort_Embaralhado10k", 1);

        testarVetores(vetorCrescente15k, "SelectionSort_Crescente15k", 1);
        testarVetores(vetorDecrescente15k, "SelectionSort_Decrescente15k", 1);
        testarVetores(vetorEmbaralhado15k, "SelectionSort_Embaralhado15k", 1);

        // Insertion Sort
        // O insertion 5k e 10k crescente apresenta normalidade, porem o restante consta
        // com os resultados estranhos

        testarVetores(vetorCrescente5k, "InsertionSort_Crescente5k", 2);
        testarVetores(vetorDecrescente5k, "InsertionSort_Decrescente5k", 2);
        testarVetores(vetorEmbaralhado5k, "InsertionSort_Embaralhado5k", 2);

        testarVetores(vetorCrescente10k, "InsertionSort_Crescente10k", 2);
        testarVetores(vetorDecrescente10k, "InsertionSort_Decrescente10k", 2);
        testarVetores(vetorEmbaralhado10k, "InsertionSort_Embaralhado10k", 2);

        testarVetores(vetorCrescente15k, "InsertionSort_Crescente15k", 2);
        testarVetores(vetorDecrescente15k, "InsertionSort_Decrescente15k", 2);
        testarVetores(vetorEmbaralhado15k, "InsertionSort_Embaralhado15k", 2);

        // Merge Sort

        testarVetores(vetorCrescente5k, "MergeSort_Crescente5k", 3);
        testarVetores(vetorDecrescente5k, "MergeSort_Decrescente5k", 3);
        testarVetores(vetorEmbaralhado5k, "MergeSort_Embaralhado5k", 3);

        testarVetores(vetorCrescente10k, "MergeSort_Crescente10k", 3);
        testarVetores(vetorDecrescente10k, "MergeSort_Decrescente10k", 3);
        testarVetores(vetorEmbaralhado10k, "MergeSort_Embaralhado10k", 3);

        testarVetores(vetorCrescente15k, "MergeSort_Crescente15k", 3);
        testarVetores(vetorDecrescente15k, "MergeSort_Decrescente15k", 3);
        testarVetores(vetorEmbaralhado15k, "MergeSort_Embaralhado15k", 3);

        // Quick Sort

        testarVetores(vetorCrescente5k, "QuickSort_Crescente5k", 4);
        testarVetores(vetorDecrescente5k, "QuickSort_Decrescente5k", 4);
        testarVetores(vetorEmbaralhado5k, "QuickSort_Embaralhado5k", 4);

        testarVetores(vetorCrescente10k, "QuickSort_Crescente10k", 4);
        testarVetores(vetorDecrescente10k, "QuickSort_Decrescente10k", 4);
        testarVetores(vetorEmbaralhado10k, "QuickSort_Embaralhado10k", 4);

        testarVetores(vetorCrescente15k, "QuickSort_Crescente15k", 4);
        testarVetores(vetorDecrescente15k, "QuickSort_Decrescente15k", 4);
        testarVetores(vetorEmbaralhado15k, "QuickSort_Embaralhado15k", 4);

        // Quick Sort Java
        // Todos do 5k apresentam normalidade, alguns do 10k tambem, todos os 15k estão
        // com aparente anormalidade

        testarVetores(vetorCrescente5k, "QuickJava_Crescente5k", 5);
        testarVetores(vetorDecrescente5k, "QuickJava_Decrescente5k", 5);
        testarVetores(vetorEmbaralhado5k, "QuickJava_Embaralhado5k", 5);

        testarVetores(vetorCrescente10k, "QuickJava_Crescente10k", 5);
        testarVetores(vetorDecrescente10k, "QuickJava_Decrescente10k", 5);
        testarVetores(vetorEmbaralhado10k, "QuickJava_Embaralhado10k", 5);

        testarVetores(vetorCrescente15k, "QuickJava_Crescente15k", 5);
        testarVetores(vetorDecrescente15k, "QuickJava_Decrescente15k", 5);
        testarVetores(vetorEmbaralhado15k, "QuickJava_Embaralhado15k", 5);

        // Quick Sort Random

        testarVetores(vetorCrescente5k, "QuickRandom_Crescente5k", 6);
        testarVetores(vetorDecrescente5k, "QuickRandom_Decrescente5k", 6);
        testarVetores(vetorEmbaralhado5k, "QuickRandom_Embaralhado5k", 6);

        testarVetores(vetorCrescente10k, "QuickRandom_Crescente10k", 6);
        testarVetores(vetorDecrescente10k, "QuickRandom_Decrescente10k", 6);
        testarVetores(vetorEmbaralhado10k, "QuickRandom_Embaralhado10k", 6);

        testarVetores(vetorCrescente15k, "QuickRandom_Crescente15k", 6);
        testarVetores(vetorDecrescente15k, "QuickRandom_Decrescente15k", 6);
        testarVetores(vetorEmbaralhado15k, "QuickRandom_Embaralhado15k", 6);

        // Counting Sort

        testarVetores(vetorCrescente5k, "CoutingSort_Crescente5k", 7);
        testarVetores(vetorDecrescente5k, "CoutingSort_Decrescente5k", 7);
        testarVetores(vetorEmbaralhado5k, "CoutingSort_Embaralhado5k", 7);

        testarVetores(vetorCrescente10k, "CoutingSort_Crescente10k", 7);
        testarVetores(vetorDecrescente10k, "CoutingSort_Decrescente10k", 7);
        testarVetores(vetorEmbaralhado10k, "CoutingSort_Embaralhado10k", 7);

        testarVetores(vetorCrescente15k, "CoutingSort_Crescente15k", 7);
        testarVetores(vetorDecrescente15k, "CoutingSort_Decrescente15k", 7);
        testarVetores(vetorEmbaralhado15k, "CoutingSort_Embaralhado15k", 7);
    }
}