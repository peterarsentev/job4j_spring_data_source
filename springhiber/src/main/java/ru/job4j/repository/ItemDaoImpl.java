
package ru.job4j.repository;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.model.Item;

import java.util.List;

@Repository
@Transactional
public class ItemDaoImpl implements ItemDao {
    private SessionFactory sessionFactory;

    public ItemDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Item> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Item", Item.class).list();
    }

    @Override
    public void insert(Item item) {
        sessionFactory.getCurrentSession().persist(item);
    }
}
