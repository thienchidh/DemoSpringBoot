package com.example.demospringboot.controller;

import com.example.demospringboot.entities.Task;
import com.example.demospringboot.entities.User;
import com.example.demospringboot.repo.TaskRepository;
import com.example.demospringboot.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/crud")
public class CrudController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;


    @GetMapping("/addUser")
    ResponseEntity<?> addUser() {
        User user = new User();
        user.setName("user01");
        user.setAddress("address 1");

        List<Task> list = new ArrayList<>();

        list.add(taskRepository.save(Task.builder().name("task 01").deadline(Timestamp.valueOf(LocalDateTime.now())).build()));
        list.add(taskRepository.save(Task.builder().name("task 02").deadline(Timestamp.valueOf(LocalDateTime.now())).build()));
        list.add(taskRepository.save(Task.builder().name("task 03").deadline(Timestamp.valueOf(LocalDateTime.now())).build()));
        list.add(taskRepository.save(Task.builder().name("task 04").deadline(Timestamp.valueOf(LocalDateTime.now())).build()));
        list.add(taskRepository.save(Task.builder().name("task 05").deadline(Timestamp.valueOf(LocalDateTime.now())).build()));
        user.setTaskList(list);

        userRepository.save(user);

        return ResponseEntity.ok(user);
    }

    @PostMapping("/addNewUser")
    ResponseEntity<?> addNewUser(@RequestBody User user) {
        if (user.getTaskList() != null) {
            taskRepository.saveAll(user.getTaskList());
        }
        User save = userRepository.save(user);
        return ResponseEntity.ok(save);
    }

    @PostMapping("/deleteUser")
    ResponseEntity<?> deleteUser(@RequestParam(name = "userId") Long userId) {
        userRepository.deleteById(userId);

        return ResponseEntity.ok().build();
    }



    @GetMapping("/getAllUser")
    ResponseEntity<?> getAllUser() {
        List<User> all = userRepository.findAll();

        return ResponseEntity.ok(all);
    }

    @GetMapping("/getAllTask")
    ResponseEntity<?> getAllTask() {
        List<Task> all = taskRepository.findAll();

        return ResponseEntity.ok(all);
    }


}
