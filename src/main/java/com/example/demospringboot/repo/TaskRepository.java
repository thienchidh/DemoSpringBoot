package com.example.demospringboot.repo;

import com.example.demospringboot.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
