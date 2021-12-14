package ru.job4j.di;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(ConsoleInput.class);
        context.reg(StartUi.class);

        StartUi ui = context.get(StartUi.class);

        ui.add("Petr Arsentev");
        ui.add("Ivan Ivanov");
        ui.print();
        ui.askStr("Сколько вам лет?");
        ui.askInt("спасибо!");
    }
}
