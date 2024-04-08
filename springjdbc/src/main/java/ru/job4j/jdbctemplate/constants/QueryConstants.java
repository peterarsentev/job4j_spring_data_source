package ru.job4j.jdbctemplate.constants;

public enum QueryConstants {
    ;
    public static final String INSERT =
      "INSERT INTO customer (fio, phone, address, created) VALUES (:fio, :phone, :address, :created) RETURNING ID";
    public static final String SELECT = "SELECT * FROM customer WHERE customer.id = :id";
    public static final String UPDATE =
      "UPDATE customer SET fio = :fio, address = :address, phone = :phone WHERE id = :id";
    public static final String DELETE = "DELETE FROM customer WHERE id = :id";
    public static final String SELECT_ALL = "SELECT id, fio, phone, address, created FROM customer";
}
