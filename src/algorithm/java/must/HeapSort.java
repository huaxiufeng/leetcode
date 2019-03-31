package algorithm.java.must;

import java.util.Arrays;

/**
 * Created by huaxiufeng on 19/1/8.
 */
public class HeapSort {

    public void sort(int[] arr) {
        // 构建大顶堆
        //从第一个非叶子结点开始，从下至上调整结构
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        // 每次将堆顶最大的元素与末尾元素进行交换，重新对剩余的堆进行调整
        for (int n = arr.length - 1; n > 0; n--) {
            swap(arr, 0, n);
            adjustHeap(arr, 0, n);
        }
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     */
    private void adjustHeap(int[] arr, int i, int length) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // 找出左右子节点和当前节点最大的那个
        if (left < length && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }

        // 如果当前节点不是最大的，则交换使其成为最大的并向下继续调整大顶堆
        if (largest != i) {
            swap(arr, i, largest);
            adjustHeap(arr, largest, length);
        }
    }

    /**
     * 调整大顶堆，非递归形式
     */
    public static void adjustHeap0(int[] arr, int i, int length) {
        int temp = arr[i];
        // 从i结点的左子结点开始，也就是2i+1处开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                // 如果左子结点小于右子结点，k指向右子结点
                k = k + 1;
            }
            // 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        // 将temp值放到最终的位置
        arr[i] = temp;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort solution = new HeapSort();
        int[] arr = new int[]{5, 9, 2, 1, 8, 3, 6, 4, 7};
        solution.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
