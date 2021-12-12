package ru.job4j.array;

import java.util.Arrays;

public class SymmetricDiff {

    public static int[] diff(int[] left, int[] right) {
       int[] result = new int[left.length + right.length];
       int size = 0;

       for (int i : left) {
           boolean rsl = false;
           for (int j : right) {
               if (i == j) {
                   rsl = true;
                   break;
               }
           }
           if (!rsl) {
               result[size++] = i;
           }
       }

       for (int i : right) {
           boolean rsl = false;
           for (int j : left) {
               if (i == j) {
                   rsl = true;
                   break;
               }
           }
           if (!rsl) {
               result[size++] = i;
           }
       }
       return Arrays.copyOf(result, size);
    }
}
