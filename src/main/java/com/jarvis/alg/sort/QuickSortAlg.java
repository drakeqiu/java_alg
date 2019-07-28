package com.jarvis.alg.sort;

/**
 * @Author: jarvis
 * @Description
 * @Date: Create in 下午6:09 2019/7/28
 * @Modified By:
 */
public class QuickSortAlg {

    public static void sort(int[] needSort) {
        int length = needSort.length;
        quick(needSort, 0, length);
    }

    private static void quick(int[] needSort, int p, int r) {
        if (p < r) {
            int q = partition(needSort, p, r);
            quick(needSort, p, q - 1);
            quick(needSort, q + 1, r);
        }
    }

    private static int partition(int[] arr, int p, int r) {
        int compare = arr[r];
        int i = p - 1;
        for (int j = p; j < r - 1; ++j) {
            if (compare <= arr[j]) {
                ++i;
                swap(arr, i, j);
            }
        }
        ++i;
        swap(arr, i, r);
        return i;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {

    }
}
