package week2.Alg4;
public class QuickSort {
    public static void main(String[] args) {
        // Инициализиране на масива, който ще бъде сортиран
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        // Извикване на метода за Quick Sort
        quickSort(arr, 0, arr.length - 1);

        // Отпечатване на сортирания масив
        System.out.println("Сортиран масив:");
        printArray(arr);
    }

    // Метод за сортиране чрез Quick Sort
    static void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            // Намиране на индекса на pivot елемента
            int partitionIndex = partition(arr, begin, end);

            // Рекурсивно сортиране на левия и десния подмасив
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    // Метод за разделяне на масива
    static int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                // Размяна, ако текущият елемент е по-малък или равен на pivot
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        // Размяна на pivot елемента с елемента на неговата крайна позиция
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

    // Метод за отпечатване на масива
    static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
