package ru.job4j.jpaspring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.job4j.jpaspring.config.DataJpaConfig;
import ru.job4j.jpaspring.service.TaskService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx
                = new AnnotationConfigApplicationContext(DataJpaConfig.class);
        TaskService service = ctx.getBean(TaskService.class);
        service.findAll().forEach(System.out::println);
        service.deleteAll();
        System.out.println("Количество найденных записей после удаления: " + service.findAll().size());
        ctx.close();
    }
}
