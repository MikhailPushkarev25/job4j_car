package ru.job4j.store;

import ru.job4j.model.*;

import java.util.List;

public interface Store {

    List<BodyType> bodyTypesAll();

    List<Color> colorsAll();

    List<Mark> marksAll();

    void saveItem(Item item);

    List<Item> itemJoin();

    void updateItem(int id);

    User usersEmail(String email);

    void saveUser(User user);
}
