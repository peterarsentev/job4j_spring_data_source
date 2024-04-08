package ru.job4j.jpaspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.job4j.jpaspring.model.Task;
import ru.job4j.jpaspring.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository repository;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> findAll() {
        return repository.findAll();
    }

    public Task save(Task task) {
        return repository.save(task);
    }

    public void deleteTaskById(Long id) {
        repository.deleteById(id);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
