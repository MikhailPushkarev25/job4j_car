package ru.job4j.array;

public class NumberToArray {

    public static int[] resolve(int number) {
        String[] result = String.valueOf(number).split("");
        int[] array = new int[result.length];
        int size = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(result[result.length - 1 - i]);
        }
        return array;
    }
}
