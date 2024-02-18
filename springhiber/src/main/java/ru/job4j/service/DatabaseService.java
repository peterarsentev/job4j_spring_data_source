package ru.job4j.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.model.Item;
import ru.job4j.repository.ItemDao;
import java.util.List;

@Transactional
public class DatabaseService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private ItemDao itemDao;

    public void init() {
        for (int i = 1; i <= 10; i++) {
            String itemName = "Item " + i;
            Item item = new Item();
            item.setName(itemName);
            itemDao.insert(item);
        }
    }

    public void clear() {
        sessionFactory.getCurrentSession().createQuery("delete from Item i").executeUpdate();
    }

    public List<Item> getAll() {
        return itemDao.getAll();
    }
}
