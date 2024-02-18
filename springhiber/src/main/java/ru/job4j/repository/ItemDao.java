package ru.job4j.repository;

import ru.job4j.model.Item;
import java.util.List;

public interface ItemDao {

    List<Item> getAll();

    void insert(Item item);
}
