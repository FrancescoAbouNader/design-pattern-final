package com.fges.todoapp.tools;

import com.fges.todoapp.services.command.CommandService;
import com.fges.todoapp.services.command.InsertCommand;
import com.fges.todoapp.services.datasource.ToDoService;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class YAMLParser {

    private Yaml yaml;
    private InputStream stream;
    private List<Map<String, String>> sources;
    private List<Map<String, String>> commands;

    public YAMLParser(){
        this.yaml = new Yaml();
        this.stream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("Configuration.yaml");

        Map<String, List<Map<String, String>>> config = yaml.load(stream);
        config.forEach((key, value) -> {
            if(key.equals("sources")){
                this.sources = value;
            }
            else if(key.equals("commands")){
                this.commands = value;
            }
        });
    }

    public List<Map<String, String>> getCommands() {
        return this.commands;
    }

    public List<Map<String, String>> getDataSources() {
        return this.sources;
    }

    public String getCommandClassByName(String name){
        for(Map<String, String> command : this.commands){
            if(command.get("name").equals(name)){
                return command.get("class");
            }
        }
        return null;
    }

    public String getServiceClassByExtension(String extension){
        for(Map<String, String> source : this.sources){
            if(source.get("extension").equals(extension)){
                return source.get("class");
            }
        }
        return null;
    }
}
