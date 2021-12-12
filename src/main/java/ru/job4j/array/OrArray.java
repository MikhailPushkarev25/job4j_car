package ru.job4j.array;


import java.util.Arrays;

public class OrArray {

    public static int[] or(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int size = 0;
        for (int i : left) {
            result[size++] = i;
        }
        for (int j : right) {
            boolean rsl = false;
            for (int s : result) {
                if (j == s) {
                    rsl = true;
                    break;
                }
            }
            if (!rsl) {
                result[size++] = j;
            }
        }
        return Arrays.copyOf(result, size);
    }
}
