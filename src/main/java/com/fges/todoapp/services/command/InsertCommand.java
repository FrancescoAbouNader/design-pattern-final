package com.fges.todoapp.services.command;

import com.fges.todoapp.models.ToDoItem;
import com.fges.todoapp.services.datasource.ToDoService;

public class InsertCommand extends CommandService{

    private ToDoService toDoService;
    private ToDoItem toDoItem;

    public InsertCommand(ToDoService service,ToDoItem toDoItem) {
        this.toDoService = service;
        this.toDoItem = toDoItem;
    }

    @Override
    public void execute() {
        this.toDoService.saveToDo(this.toDoItem);
    }
}
