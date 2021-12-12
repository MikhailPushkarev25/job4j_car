package ru.job4j.array;

import java.util.Arrays;

public class AndArray {

    public static int[] and(int[] left, int[] right) {
        return Arrays.stream(left)
                .distinct()
                .filter(x -> Arrays.stream(right).anyMatch(y -> y == x))
                .toArray();
    }
}
