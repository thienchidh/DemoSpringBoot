package com.example.demospringboot.controller;

import com.example.demospringboot.entities.Task;
import com.example.demospringboot.entities.User;
import com.example.demospringboot.repo.TaskRepository;
import com.example.demospringboot.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/test01")
    String test01() {

        return "test";
    }


    @GetMapping("/test02")
    ResponseEntity<?> test02() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/test03")
    ResponseEntity<?> test03() {
        int[] arr = new int[]{1, 2, 3, 4};
        return ResponseEntity.ok(arr);
    }


    @GetMapping("/test04")
    ResponseEntity<?> test04() {
        Task task = new Task();
        task.setName("task1");
        task.setDeadline(Timestamp.valueOf(LocalDateTime.now()));

        return ResponseEntity.ok(task);
    }

    @GetMapping("/test05")
    ResponseEntity<?> test05() {
        User user = new User();
        user.setName("user01");
        user.setAddress("address 1");

        return ResponseEntity.ok(user);
    }


}
