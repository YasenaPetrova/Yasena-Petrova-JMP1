package week2.Alg3;

public class Main {
    public static void main(String args[]) {
        int size = 10000; // Размер на масива
        int[] arr = new int[size];
        // Генериране на случайни числа
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * size);
        }

        // Създаване на обект и сортиране с BubbleSort
        long startTime = System.currentTimeMillis();
        new BubbleSort().bubbleSort(arr.clone()); // Използвайте .clone(), за да не сортирате вече сортирания масив
        long endTime = System.currentTimeMillis();
        System.out.println("Bubble Sort време за изпълнение: " + (endTime - startTime) + " милисекунди");

        // Създаване на обект и сортиране с QuickSort
        startTime = System.currentTimeMillis();
        new QuickSort().sort(arr.clone(), 0, size-1);
        endTime = System.currentTimeMillis();
        System.out.println("Quick Sort време за изпълнение: " + (endTime - startTime) + " милисекунди");
    }

}
