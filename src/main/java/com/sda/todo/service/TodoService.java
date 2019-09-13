package com.sda.todo.service;

import com.sda.todo.model.Todo;
import com.sda.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService  {

    @Autowired
    private TodoRepository repository;

    public List<Todo> all(){
        List<Todo> list = new ArrayList<>();
        repository.findAll().forEach(list::add);
        return list;
    }



    public Todo getEmptyTask(){
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Date dateFromCalendar = calendar1.getTime();
        Date dateFromCalendar2 = calendar2.getTime();
        return new Todo("Do zrobienia", dateFromCalendar, dateFromCalendar2, "Podaj tytuł", "Treść zadania");

    }
    public Todo getSimpleTask(){
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Date dateFromCalendar = calendar1.getTime();
        calendar2.add(Calendar.DATE, 5);
        return new Todo("Do zrobienia", dateFromCalendar, calendar2.getTime(), "Podaj tytuł", "Treść zadania");

    }

    public Todo modifyTask(Todo task){
        task.setStatus(task.getStatus() + "*");
        task.setEndDate(task.getEndDate());
        task.setTitle(task.getTitle() + "*");
        task.setTask(task.getTask() + "*");
        return task;
    }

    public Long addTask(Todo newTask){

        Map<Long, Todo> taskList = TodoFactory.create();
        Long newKey = 1L + Collections.max(taskList.keySet());
        taskList.put(newKey, newTask);
        return repository.add(newTask);
    }

    public Todo getTask(Long id){
        return repository.getById(id);
    }
    static class TodoFactory{

        static Map<Long, Todo> create(){
            Map<Long, Todo> tasks = new HashMap<>();
            return tasks;
        }
    }

}
