package com.fges.todoapp.services.datasource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fges.todoapp.models.ToDoItem;
import com.fges.todoapp.models.ToDoList;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JSONService extends ToDoService{

    @Override
    public ToDoList getTodos() {
        return null;
    }

    @Override
    public void saveToDo(ToDoItem todo) {
        System.out.println("From JSON Service");
        System.out.println(todo.toString());
    }
}