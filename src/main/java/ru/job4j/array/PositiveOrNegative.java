package ru.job4j.array;

public class PositiveOrNegative {

    public static boolean check(int[] data) {
        boolean rsl = false;

        for (int i = 0; i < data.length / 2; i++) {
          if (data[i] < 0) {
              if (data[i] % 2 != 0) {
                  rsl = true;
              } else {
                  rsl = false;
              }
          }
        }
        return rsl;
    }
}
