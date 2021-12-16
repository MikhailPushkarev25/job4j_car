package ru.job4j.array;

public class EvenVsOdd {

    public static int whoWin(int[] players) {
        int EvenSize = 0, OddSize = 0, size = 0;
       for (int i = 0; i < players.length; i++) {
           if (i % 2 == 0) {
               EvenSize += players[i];
           } else {
               OddSize += players[i];
           }
       }
       if (EvenSize > OddSize) {
           return 1;
       } else if (OddSize > EvenSize) {
           return 2;
       }
       return 0;
    }
}
