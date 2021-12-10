package ru.job4j.array;

import java.util.Arrays;

public class CheckSumIndexes {

    public static int[] collectNewArray(int[][] data, int sum) {
        int[] arr = new int[data.length * data.length];
        int size = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (i + j != sum) {
                    arr[size++] = data[i][j];
                }
            }
        }
        return Arrays.copyOf(arr, size);
    }
}
