package com.fges.todoapp.services.datasource;

import com.fges.todoapp.models.ToDoItem;
import com.fges.todoapp.models.ToDoList;

public interface ToDoInterface {
    public ToDoList getTodos();
    public void saveToDo(ToDoItem todo);
}
