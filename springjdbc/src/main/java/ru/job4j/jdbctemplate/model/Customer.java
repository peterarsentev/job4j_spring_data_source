package ru.job4j.jdbctemplate.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Customer {
    private long id;
    private String fio;
    private String phone;
    private String address;
    private LocalDateTime created;

    public Customer(String fio, String phone, String address, LocalDateTime created) {
        this.fio = fio;
        this.phone = phone;
        this.address = address;
        this.created = created;
    }

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer customer)) return false;
        return id == customer.id && Objects.equals(fio, customer.fio) && Objects.equals(phone, customer.phone) && Objects.equals(address, customer.address) && Objects.equals(created, customer.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fio, phone, address, created);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", created=" + created +
                '}';
    }
}
