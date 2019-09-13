package com.sda.todo.repository;

import com.sda.todo.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TodoRepository extends CrudRepository <Todo, Long> {

    Long add(Todo task);
    Todo getById(Long id);

}
