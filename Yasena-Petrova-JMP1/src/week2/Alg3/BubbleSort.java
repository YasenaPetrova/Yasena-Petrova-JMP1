package week2.Alg3;
public class BubbleSort {
    void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1]) {
                    // разменя arr[j+1] и arr[j]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    public static void main(String args[]) {
        BubbleSort ob = new BubbleSort();
        int arr[] = {64, 34, 25, 12, 22, 11, 90}; // Примерен масив
        ob.bubbleSort(arr);
        System.out.println("Сортираният масив");
        for (int i=0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
