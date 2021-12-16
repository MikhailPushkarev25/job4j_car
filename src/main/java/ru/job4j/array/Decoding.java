package ru.job4j.array;

public class Decoding {

    public static int[] decode(int[] ints, int number) {
        int[] result = new int[ints.length];
        int size = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] % number == 0) {
                result[size++] = ints[i] % number;
            } else {
                result[size++] = ints[i] % number;
            }
        }
        return result;
    }
}
