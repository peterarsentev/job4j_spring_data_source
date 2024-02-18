package ru.job4j.jdbctemplate.repository;

import ru.job4j.jdbctemplate.model.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer createCustomer(Customer customer);

    Customer findCustomerById(long id);

    void updateCustomer(Customer customer);

    void deleteCustomer(long id);

    List<Customer> findAll();
}
