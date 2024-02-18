package ru.job4j.jpaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.job4j.jpaspring.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
