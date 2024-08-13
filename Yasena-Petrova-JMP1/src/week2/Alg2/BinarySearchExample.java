package week2.Alg2;

import java.util.Scanner;

public class BinarySearchExample {

    // Метод за двоично търсене
    public static int binarySearch(int arr[], int elementToFind) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Проверка дали елементът е в средата
            if (arr[mid] == elementToFind)
                return mid;

            // Ако елементът е по-голям, игнорира лявата част
            if (arr[mid] < elementToFind)
                left = mid + 1;

                // Ако елементът е по-малък, игнорира дясната част
            else
                right = mid - 1;
        }

        // Ако елементът не е намерен в масива
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Въведете броя на елементите в масива: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.println("Въведете елементите на сортирания масив: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Въведете елемента за търсене: ");
        int elementToFind = scanner.nextInt();

        int result = binarySearch(arr, elementToFind);

        if (result == -1)
            System.out.println("Елементът не е намерен в масива.");
        else
            System.out.println("Елементът е намерен на индекс: " + result);
    }
}
