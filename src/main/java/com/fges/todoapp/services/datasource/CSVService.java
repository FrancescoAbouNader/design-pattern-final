package com.fges.todoapp.services.datasource;

import com.fges.todoapp.models.ToDoItem;
import com.fges.todoapp.models.ToDoList;

public class CSVService extends ToDoService{
    @Override
    public ToDoList getTodos() {
        return null;
    }

    @Override
    public void saveToDo(ToDoItem todo) {
        System.out.println("From CSV Service");
        System.out.println(todo.toString());
    }
}
