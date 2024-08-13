package week2.Alg4;
public class BubbleSort {
    public static void main(String[] args) {
        // Инициализиране на масива, който ще бъде сортиран
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        // Извикване на метода за Bubble Sort
        bubbleSort(arr);

        // Отпечатване на сортирания масив
        System.out.println("Сортиран масив:");
        printArray(arr);
    }

    // Метод за сортиране чрез Bubble Sort
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                // Сравняване на съседни елементи
                if (arr[j] > arr[j+1]) {
                    // Размяна, ако елементите не са в правилния ред
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            // Отпечатване на масива след всяка външна итерация
            System.out.println("След итерация " + (i + 1) + ": ");
            printArray(arr);
        }
    }

    // Метод за отпечатване на масива
    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

