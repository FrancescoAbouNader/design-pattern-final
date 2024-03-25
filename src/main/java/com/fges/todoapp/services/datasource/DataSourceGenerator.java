package com.fges.todoapp.services.datasource;

import com.fges.todoapp.tools.YAMLParser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class DataSourceGenerator {

    ToDoService service;

    public DataSourceGenerator(String filePath){
        String extension = filePath.split("\\.")[1];
        YAMLParser yamlParser = new YAMLParser();
        String ServiceClassName = yamlParser.getServiceClassByExtension(extension);
        try {
            Class<?> serviceClass = Class.forName(ServiceClassName);
            this.service = (ToDoService) serviceClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ToDoService getService() {
        return service;
    }
}
