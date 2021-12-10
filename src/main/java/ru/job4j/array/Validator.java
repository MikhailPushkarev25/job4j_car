package ru.job4j.array;

public class Validator {

    public static boolean checkArray(int[] data, int value) {
        boolean rsl = false;
        int res = 0;
        for (int i = 0; i < data.length; i++) {
            if (value == data[i]) {
                res += value;
                if (res >= data.length / 2) {
                    rsl = false;
                } else {
                    rsl = true;
                }
            }
        }
        return rsl;
    }
}
