package com.fges.todoapp.services.command;

import com.fges.todoapp.models.ToDoItem;
import com.fges.todoapp.services.datasource.ToDoService;
import com.fges.todoapp.tools.YAMLParser;

import java.lang.reflect.Constructor;

public class CommandGenerator {
    CommandService commandService;

    public CommandGenerator(String command, String todo, ToDoService service) {
        YAMLParser yamlParser = new YAMLParser();
        String commandClass = yamlParser.getCommandClassByName(command);
        ToDoItem item = new ToDoItem(todo,false);
        try {
            Class<?> commandClasss = Class.forName(commandClass);
            Constructor<?> constructor = commandClasss.getConstructor(ToDoService.class, ToDoItem.class);
            this.commandService = (CommandService) constructor.newInstance(service,item);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CommandGenerator(String command, ToDoService service) {
        YAMLParser yamlParser = new YAMLParser();
        String commandClass = yamlParser.getCommandClassByName(command);
    }

    public CommandService getService(){
        return commandService;
    }
}