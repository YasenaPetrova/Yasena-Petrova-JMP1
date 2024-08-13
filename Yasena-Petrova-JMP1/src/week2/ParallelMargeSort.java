package week2;

import java.util.Arrays;


    public   class ParallelMargeSort {
        public static void main(String[] args) {
            int[] array = {5, 3, 2, 8, 1, 4};
            ParallelArraySorter.sort(array);
            System.out.println(Arrays.toString(array));
        }
    }

    class ParallelArraySorter {
        public static void sort(int[] array) {
            if (array.length < 2) return;
            int mid = array.length / 2;
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, array.length);

            Thread leftSorter = new Thread(() -> sort(left));
            Thread rightSorter = new Thread(() -> sort(right));

            leftSorter.start();
            rightSorter.start();

            try {
                leftSorter.join();
                rightSorter.join();
                merge(left, right, array);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private static void merge(int[] left, int[] right, int[] result) {
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    result[k++] = left[i++];
                } else {
                    result[k++] = right[j++];
                }
            }
            while (i < left.length) {
                result[k++] = left[i++];
            }
            while (j < right.length) {
                result[k++] = right[j++];
            }
        }
    }
