package ru.job4j.jdbctemplate.repository;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import ru.job4j.jdbctemplate.model.Customer;
import ru.job4j.jdbctemplate.model.CustomerRowMapper;

import java.util.List;
import java.util.Map;

import static ru.job4j.jdbctemplate.constants.QueryConstants.*;

public class CustomerRepositoryImpl implements CustomerRepository {
    private NamedParameterJdbcTemplate template;
    public void setJdbcTemplate(NamedParameterJdbcTemplate jdbcTemplate) {
        this.template = jdbcTemplate;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValues(Map.of(
                "fio", customer.getFio(),
                "phone", customer.getPhone(),
                "address", customer.getAddress(),
                "created", customer.getCreated()));
        Long idFromBd = template.queryForObject(INSERT, parameterSource, Long.class);
        if (idFromBd != null) {
            customer.setId(idFromBd);
        }
        return customer;
    }

    @Override
    public Customer findCustomerById(long id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        return template.queryForObject(SELECT, parameterSource, new CustomerRowMapper());
    }

    @Override
    public void updateCustomer(Customer customer) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValues(Map.of(
                        "id", customer.getId(),
                        "fio", customer.getFio(),
                        "phone", customer.getPhone(),
                        "address", customer.getAddress()));
        template.update(UPDATE, parameterSource);
    }

    @Override
    public void deleteCustomer(long id) {
        SqlParameterSource parameterSource = new MapSqlParameterSource("id", id);
        template.update(DELETE, parameterSource);
    }

    @Override
    public List<Customer> findAll() {
        return template.query(SELECT_ALL, new CustomerRowMapper());
    }


}
