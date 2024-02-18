package ru.job4j.jpaspring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.jpaspring.model.Task;
import ru.job4j.jpaspring.repository.TaskRepository;
import javax.annotation.PostConstruct;

@Service
public class DBInit {
    private static Logger logger = LoggerFactory.getLogger(DBInit.class);
    private TaskRepository repository;

    @Autowired
    public DBInit(TaskRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void initDB() {
        logger.info("Starting database initialization...");
        for (int i = 1; i <=5; i++) {
            Task task = new Task(0L, "task%s".formatted(i));
            repository.save(task);
        }
    }
}
