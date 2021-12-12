package ru.job4j.array;

import java.util.Arrays;

public class DiffArray {

    public static int[] diff(int[] left, int[] right) {
        int[] result = new int[left.length];
        if (right.length == 0) {
            result = left;
            return result;
        }
        int size = 0;
        for (int i = 0; i < left.length; i++) {
            for (int j = 0; j < right.length; j++) {
                if (left[i] != right[j]) {
                    result[size++] = left[i];
                }
            }
        }
        return Arrays.copyOf(result, size);
    }
}
