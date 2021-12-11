package ru.job4j.array;

public class Initials {

    public static String convert(String[] fio) {
       String answer = fio[0] + " ";
        for (int i = 1; i < fio.length; i++) {
           answer += fio[i].substring(0, 1).toUpperCase() + ".";
        }
        return answer.trim();
    }
}
