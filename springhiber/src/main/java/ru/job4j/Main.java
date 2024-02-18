package ru.job4j;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.job4j.config.SpringConfiguration;
import ru.job4j.model.Item;
import ru.job4j.service.DatabaseService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        DatabaseService service = context.getBean(DatabaseService.class);
        service.init();
        for (Item el: service.getAll()) {
            System.out.println("el = " + el);
        }
        service.clear();
        context.close();
    }
}
