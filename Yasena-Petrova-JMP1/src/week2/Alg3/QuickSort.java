package week2.Alg3;

public class QuickSort {
    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low-1); // индекс на по-малкия елемент
        for (int j=low; j<high; j++) {
            // Ако текущият елемент е по-малък от опорния
            if (arr[j] < pivot) {
                i++;
                // разменя arr[i] и arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // разменя arr[i+1] и arr[high] (или опорния елемент)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }

    void sort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    public static void main(String args[]) {
        int arr[] = {10, 7, 8, 9, 1, 5}; // Примерен масив
        int n = arr.length;
        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);
        System.out.println("Сортираният масив:");
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
    }
}
