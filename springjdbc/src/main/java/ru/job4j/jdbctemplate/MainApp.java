package ru.job4j.jdbctemplate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.job4j.jdbctemplate.config.SpringNamedJdbcTemplateCfg;
import ru.job4j.jdbctemplate.model.Customer;
import ru.job4j.jdbctemplate.repository.CustomerRepository;

import java.time.LocalDateTime;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringNamedJdbcTemplateCfg.class);
        CustomerRepository customerCustomerRepository = ctx.getBean("store", CustomerRepository.class);
        Customer customerOne = new Customer(
                "fioOne",
                "addressOne",
                "phoneOne",
                LocalDateTime.now().withNano(0));
        Customer customerTwo = new Customer(
                "fioTwo",
                "addressTwo",
                "phoneTwo",
                LocalDateTime.now().withNano(0));
        customerCustomerRepository.createCustomer(customerOne);
        System.out.printf("customerOne = %s%n", customerOne);
        customerCustomerRepository.createCustomer(customerTwo);
        System.out.printf("customerTwo = %s%n", customerTwo);
        System.out.println("---- FindAll ----");
        List<Customer> list = customerCustomerRepository.findAll();
        list.forEach(System.out::println);
        System.out.println("---- after Update CustomerOne----");
        System.out.printf("CustomerOne before update =  %s%n",
                customerCustomerRepository.findCustomerById(customerOne.getId()));
        customerOne.setFio("edit");
        customerCustomerRepository.updateCustomer(customerOne);
        customerCustomerRepository.findAll().forEach(System.out::println);
        System.out.println("---- after delete ----");
        customerCustomerRepository.deleteCustomer(customerTwo.getId());
        customerCustomerRepository.findAll().forEach(System.out::println);
    }
}
