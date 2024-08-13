package week2.Alg1;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSortExample {
    // Този метод взема последния елемент като pivot,
    // поставя елемента pivot на правилната му позиция в сортирания масив,
    // и поставя всички по-малки от pivot наляво от него и всички по-големи надясно от него.
    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // Индекс на по-малкия елемент
        for (int j = low; j < high; j++) {
            // Ако текущият елемент е по-малък от или равен на pivot
            if (arr[j] <= pivot) {
                i++;

                // размяна на arr[i] и arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // размяна на arr[i+1] и arr[high] (или pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // arr[] --> Масивът за сортиране,
    // low --> Начален индекс,
    // high --> Краен индекс
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Въведете размер на масива: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Въведете елементите на масива: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        quickSort(arr, 0, arr.length - 1);
        System.out.println("Сортиран масив: " + Arrays.toString(arr));
    }
}


