package algorithm.java.must;

import java.util.Arrays;

/**
 * Created by huaxiufeng on 18/11/5.
 */
public class QuickSort {

    public void quickSort(int[] arr) {
        doQuickSort(arr, 0, arr.length - 1);
    }

    private void doQuickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int k = partition(arr, begin, end);
            doQuickSort(arr, begin, k - 1);
            doQuickSort(arr, k + 1, end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[(begin + end) / 2];
        int l = begin;
        int h = end;
        while (l < h) {
            while (arr[l] < pivot && l < h) {
                l++;
            }
            while (arr[h] > pivot && l < h) {
                h--;
            }
            swap(arr, l, h);
        }
        return l;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] arr = new int[]{4, 7, 2, 5, 3, 6, 1, 9, 8};
        solution.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
