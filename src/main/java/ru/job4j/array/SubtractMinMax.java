package ru.job4j.array;

public class SubtractMinMax {

    public static int calculate(int[] ints) {
        int max = ints[0];
        int min = ints[0] + 1;
        int buff = 0, res = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > max) {
                max = ints[i];
                res = max;
            } else if (ints[i] < min) {
                min = ints[i];
            }
            buff = res - min;
        }
        return buff;
    }
}
