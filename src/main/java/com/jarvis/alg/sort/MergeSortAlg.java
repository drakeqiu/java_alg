package com.jarvis.alg.sort;

/**
 * @Author: jarvis
 * @Description
 * @Date: Create in 下午6:39 2019/7/28
 * @Modified By:
 */
public class MergeSortAlg {

    private static void merge(int[] needSort, int low, int middle, int high) {
        int left = middle - low + 1;
        int right = high - middle;
        int i = 0, j = 0;
        int[] leftArr = new int[left + 1];
        int[] rightArr = new int[right + 1];

        for (i = 0; i < left; ++i) {
            leftArr[i] = needSort[low + i - 1];
        }

        for (i = 0; i < right; ++i) {
            rightArr[i] = needSort[middle + i];
        }

        leftArr[left] = Integer.MAX_VALUE;
        rightArr[right] = Integer.MAX_VALUE;

        i = 0;
        j = 0;
        for (int k = low; k < high; ++ k) {
            if (leftArr[i] <= rightArr[j]) {
                needSort[k] = leftArr[i];
                i++;
            } else {
                needSort[k] = rightArr[j];
                j++;
            }
        }
    }

    public static void sort(int[] needSort, int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            sort(needSort, low, middle);
            sort(needSort, middle, high);
            merge(needSort, low, middle, high);
        }
    }

    public static void main(String[] args) {

    }
}
