package week2.Alg1;

import java.util.Arrays;
import java.util.Scanner;

public  class MergeSortExample {
    // Обединява два подмасива на arr[].
    // Първият подмасив е arr[l..m]
    // Вторият подмасив е arr[m+1..r]
    public static void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Основен метод, който сортира arr[l..r] използвайки
    // merge()
    public static void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
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

        sort(arr, 0, arr.length - 1);
        System.out.println("Сортиран масив: " + Arrays.toString(arr));
    }
}