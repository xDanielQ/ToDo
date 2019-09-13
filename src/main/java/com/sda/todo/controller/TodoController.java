package com.sda.todo.controller;

import com.sda.todo.model.Todo;
import com.sda.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    public TodoService service;

    @GetMapping("/list")
    public String getAll(Model model){
        model.addAttribute("list", service.all());
        return "todoList";
    }

    @GetMapping("/add")
    public String goToAddForm(Model model){
        model.addAttribute("task", service.getEmptyTask());
        return "taskForm";
    }

    @GetMapping
    public String getTask(Model model){
        model.addAttribute("task", service.getSimpleTask());
        return "taskView";
    }

    @GetMapping
    public String setTask(Todo newTask, Model model){
        long id = service.addTask(newTask);
        model.addAttribute("task", service.getTask(id));
        return "taskView";
    }
}
