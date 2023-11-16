package assignments.atv2;

import java.util.List;
import java.util.Arrays;
import java.util.Random;

public class Ordenacao implements Ordenacao_IF {

    // Metodos extras

    public static int[] convertArrayListToArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    public boolean checaVetorOrdenado(int[] numeros) {
        if (numeros == null || numeros.length <= 1) {

            return true;
        }

        for (int i = 0; i < numeros.length - 1; i++) {
            if (numeros[i] > numeros[i + 1]) {

                return false;
            }
        }

        return true;
    }

    public void printArray(int[] numeros) {
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    ///////////////////////////////////////////////////////////////////////////

    // Metodos de Ordenação

    public long bubbleSort(int[] numeros) {// BUBBLESORT--

        long antes = System.nanoTime();

        int tam = numeros.length;

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                if (numeros[i] < numeros[j]) {
                    int aux = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = aux;
                }
            }
        }
        long depois = System.nanoTime();
        return depois - antes;

    }

    public long insertionSort(int[] numeros) {// INSERTIONSORT--

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

    public long selectionSort(int[] numeros) {// SELECTIONSORT--

        long antes = System.nanoTime();

        int tam = numeros.length;

        for (int i = 0; i < tam - 1; i++) {
            int indiceMenor = i;

            for (int j = i + 1; j < tam; j++) {
                if (numeros[j] < numeros[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            if (indiceMenor != i) {
                int temp = numeros[i];
                numeros[i] = numeros[indiceMenor];
                numeros[indiceMenor] = temp;
            }
        }

        long depois = System.nanoTime();
        return depois - antes;

    }


    public long auxMergeSort(int[] numeros) {

        int tam = numeros.length;
        if (tam <= 1) {
            return 1;
        }

        int meio = tam / 2;
        int[] esquerda = Arrays.copyOfRange(numeros, 0, meio);
        int[] direita = Arrays.copyOfRange(numeros, meio, tam);

        auxMergeSort(esquerda);
        auxMergeSort(direita);

        merge(numeros, esquerda, direita);

        return 1;

    }

    public long mergeSort(int[] numeros) {// MERGESORT--

        long antes = System.nanoTime();

        auxMergeSort(numeros);

        long depois = System.nanoTime();
        return depois - antes;

    }

    public static void merge(int[] array, int[] esquerda, int[] direita) {
        int tamEsquerda = esquerda.length;
        int tamDireita = direita.length;

        int i = 0, j = 0, k = 0;

        while (i < tamEsquerda && j < tamDireita) {
            if (esquerda[i] < direita[j]) {
                array[k++] = esquerda[i++];
            } else {
                array[k++] = direita[j++];
            }
        }

        while (i < tamEsquerda) {
            array[k++] = esquerda[i++];
        }

        while (j < tamDireita) {
            array[k++] = direita[j++];
        }
    }


    public long quickSort(int[] numeros) {// QUICKSORT--
        long antes = System.nanoTime();

        int inicio = 0;
        auxQuickSort(numeros, inicio, numeros.length - 1);

        long depois = System.nanoTime();
        return depois - antes;
    }

    public long auxQuickSort(int[] numeros, int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(numeros, inicio, fim);
            auxQuickSort(numeros, inicio, indicePivo - 1);
            auxQuickSort(numeros, indicePivo + 1, fim);
        }
        return 1;
    }
    

    public static int particionar(int[] array, int inicio, int fim) {
        int pivo = array[fim];
        int indicePivo = inicio;
    
        for (int i = inicio; i <= fim; i++) {
            if (array[i] < pivo) {
                int temp = array[i];
                array[i] = array[indicePivo];
                array[indicePivo] = temp;
                indicePivo++;
            }
        }
    
        int temp = array[fim];
        array[fim] = array[indicePivo];
        array[indicePivo] = temp;
    
        return indicePivo;
    }

    private static int partition(int[] numeros, int low, int high, Random random) {
        int pivotIndex = low + random.nextInt(high - low + 1); // Escolhe um índice aleatório entre low e high
        int pivotValue = numeros[pivotIndex];

        int temp = numeros[pivotIndex];
        numeros[pivotIndex] = numeros[high];
        numeros[high] = temp;
        int i = low;
        for (int j = low; j < high; j++) {
            if (numeros[j] < pivotValue) {
                temp = numeros[i];
                numeros[i] = numeros[j];
                numeros[j] = temp;
                i++;
            }
        }
        temp = numeros[i];
        numeros[i] = numeros[high];
        numeros[high] = temp;
        return i;
    }


    public long quickSort_Java(int[] numeros) {// QUICKSORTJAVA--
        long antes = System.nanoTime();

        Arrays.sort(numeros);

        long depois = System.nanoTime();
        return depois - antes;
    }


    public long random_quickSort(int[] numeros) {// RANDOMQUICKSORT--
        if (numeros == null || numeros.length == 0) {
            return 0;
        }
        Random random = new Random();
        long startTime = System.nanoTime();

        auxrandom_quickSort(numeros, 0, numeros.length - 1, random);

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void auxrandom_quickSort(int[] numeros, int low, int high, Random random) {
        if (low < high) {
            int pivotIndex = partition(numeros, low, high, random);
            auxrandom_quickSort(numeros, low, pivotIndex - 1, random);
            auxrandom_quickSort(numeros, pivotIndex + 1, high, random);
        }
    }


    public long countingSort(int[] numeros) {// COUNTINGSORT--

        long antes = System.nanoTime();
    
        int maior = 0;
    
        for (int m = 0; m < numeros.length; m++) {
            if (numeros[m] > maior) {
                maior = numeros[m];
            }
        }
    
        int[] count = new int[maior + 1]; // Aumente o tamanho do array count em 1
    
        for (int j = 0; j < numeros.length; j++) {
            count[numeros[j]] += 1;
        }
    
        for (int i = 1; i <= maior; i++) { // Comece a partir de 1
            count[i] = count[i] + count[i - 1];
        }
    
        int[] temp = new int[numeros.length];
    
        for (int j = numeros.length - 1; j >= 0; j--) { // Comece de trás para frente
            temp[count[numeros[j]] - 1] = numeros[j]; // Ajuste o índice aqui
            count[numeros[j]] -= 1;
        }
    
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = temp[i];
        }
    
        long depois = System.nanoTime();
        return depois - antes;
    }
    
   }

