package ru.job4j.array;

public class DestroySequence {

    public static char[] destroy(char[] seq) {
        for (int i = 0; i < seq.length / 2; i++) {
            char mt = seq[seq.length - 1 - i];
            seq[seq.length - 1 - i] = seq[i];
            seq[i] = mt;
        }
        return seq;
    }
}
