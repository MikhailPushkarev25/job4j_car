package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.job4j.di");

        context.refresh();

        StartUi ui = context.getBean(StartUi.class);
        ui.add("Mikhail Pushkarev");
        ui.add("Roman Sokolov");
        ui.print();
        ui.askStr("Ваш возраст?");
        ui.askInt("Хорошо!");
    }
}
