package ru.job4j.array;

public class SumWithStopEl {

    public static int count(int[] data, int el) {
        int result = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] <= el) {
                 result += i;
            } else if (result % 2 != 0) {
                return 0;
            }
        }
        return result;
    }
}
