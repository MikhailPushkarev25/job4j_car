package ru.job4j.array;

public class Divider {

    public static boolean check(int num, int[] ints) {
        boolean rsl = false;

        for (int i = 0; i < ints.length; i++) {
           if (num % ints[i] == 0) {
               rsl = true;
           } else {
               rsl = false;
           }
        }
        return rsl;
    }
}
