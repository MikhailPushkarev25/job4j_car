package ru.job4j.di;

import org.springframework.stereotype.Component;

@Component
public class StartUi {

    private Store store;

    private ConsoleInput input;

    public StartUi(Store store, ConsoleInput input) {
        this.store = store;
        this.input = input;
    }

    public void add(String value) {
        store.add(value);
    }

    public String askStr(String question) {
        return input.askStr(question);
    }

    public int askInt(String question) {
        return input.askInt(question);
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }
}
