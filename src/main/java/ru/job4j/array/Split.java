package ru.job4j.array;

import java.util.Arrays;

public class Split {

    public static char[][] split(char[] str, char c) {
        char[][] result = new char[str.length / 2][];
        char[] ch = new char[str.length];
        int commonCount = 0;
        int size = 0;
        for (char res : str) {
            if (res != c) {
                ch[size++] = res;
            } else {
                result[commonCount] = Arrays.copyOf(ch, size);
                commonCount++;
                size = 0;
            }
        }
        result[commonCount] = Arrays.copyOf(ch, size);
        return Arrays.copyOf(result, commonCount + 1);

    }
}
