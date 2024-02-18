package ru.job4j.jdbctemplate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import ru.job4j.jdbctemplate.repository.CustomerRepositoryImpl;
import ru.job4j.jdbctemplate.repository.CustomerRepository;

import javax.sql.DataSource;

@Import(BasicDataSourceCfg.class)
@Configuration
public class SpringNamedJdbcTemplateCfg {

    private final DataSource dataSource;

    public SpringNamedJdbcTemplateCfg(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate(){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public CustomerRepository store(){
        CustomerRepositoryImpl dao = new CustomerRepositoryImpl();
        dao.setJdbcTemplate(jdbcTemplate());
        return dao;
    }
}
