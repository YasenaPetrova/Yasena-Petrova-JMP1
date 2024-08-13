package week2.Alg1;

import java.util.Scanner;

class BubbleSortExample {
    // Метод за Bubble Sort
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // Размяна на елементите
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Въвеждане на размера на масива от потребителя
        System.out.print("Въведете броя на елементите в масива: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        // Въвеждане на елементите на масива от потребителя
        System.out.println("Въведете елементите на масива: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Извикване на метода за Bubble Sort
        bubbleSort(arr);

        // Отпечатване на сортирания масив
        System.out.println("Сортираният масив: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}