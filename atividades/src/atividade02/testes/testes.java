package testes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class testes {

    public static void printArray(int[] numeros) {
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();
    }



    public static long insertionSort(int[] numeros) {// INSERTIONSORT--

        long antes = System.nanoTime();

        int tam = numeros.length;

        for (int fim = 1; fim < tam - 1; fim++) {
            int i = fim;
            while (i > 0 && numeros[i] < numeros[i - 1]) {
                int aux = numeros[i - 1];
                numeros[i - 1] = numeros[i];
                numeros[i] = aux;
                i--;
            }
        }

        long depois = System.nanoTime();
        return depois - antes;
    }

    public static long quickSort_Java(int[] numeros) {// QUICKSORTJAVA--
        long antes = System.nanoTime();

        Arrays.sort(numeros);

        long depois = System.nanoTime();
        return depois - antes;
    }

    public static int[] convertArrayListToArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        
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

        

        int[] vetorCrescente15k = convertArrayListToArray(arrayCrescente15k);


        int[] vetorDecrescente15k = convertArrayListToArray(arrayDecrescente15k);


        int[] vetorEmbaralhado15k = convertArrayListToArray(arrayEmbaralhado15k);


        // System.out.println(insertionSort(vetorEmbaralhado15k));
        // System.out.println(insertionSort(vetorCrescente15k));
        // System.out.println(insertionSort(vetorDecrescente15k));

        // printArray(vetorCrescente15k);
        // printArray(vetorDecrescente15k);
        // printArray(vetorEmbaralhado15k);

        quickSort_Java(vetorEmbaralhado15k);
        quickSort_Java(vetorCrescente15k);
        quickSort_Java(vetorDecrescente15k);

        // printArray(vetorCrescente15k);
        // printArray(vetorDecrescente15k);
        // printArray(vetorEmbaralhado15k);



        for(int i=0; i<50; i++){
        System.out.println(quickSort_Java(vetorEmbaralhado15k));
        System.out.println(quickSort_Java(vetorCrescente15k));
        System.out.println(quickSort_Java(vetorDecrescente15k));
        }
    }
    
}
