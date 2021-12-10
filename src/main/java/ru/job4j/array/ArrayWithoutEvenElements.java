package ru.job4j.array;

import java.util.Arrays;

public class ArrayWithoutEvenElements {

    public static int[] changeData(int[] data) {
        int result = 0;
        int[] arr = new int[data.length - 1];
        for (int i = 0; i < data.length; i++) {
            if (data[i] % 2 == 1) {
                arr[result++] = data[i];
            }
        }
        return Arrays.copyOf(arr, result);
    }
}
