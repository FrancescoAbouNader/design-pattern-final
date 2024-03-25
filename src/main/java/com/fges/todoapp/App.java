package com.fges.todoapp;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fges.todoapp.services.command.CommandGenerator;
import com.fges.todoapp.services.command.CommandService;
import com.fges.todoapp.services.command.InsertCommand;
import com.fges.todoapp.services.datasource.DataSourceGenerator;
import com.fges.todoapp.services.datasource.JSONService;
import com.fges.todoapp.services.datasource.ToDoService;
import com.fges.todoapp.tools.YAMLParser;
import org.apache.commons.cli.*;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {

    /**
     * Do not change this method
     */
    public static void main(String[] args) throws Exception {
        System.exit(exec(args));
    }

    public static int exec(String[] args) throws IOException {
        Options cliOptions = new Options();
        CommandLineParser parser = new DefaultParser();

        cliOptions.addRequiredOption("s", "source", true, "File containing the todos");

        CommandLine cmd;
        try {
            cmd = parser.parse(cliOptions, args);
        } catch (ParseException ex) {
            System.err.println("Fail to parse arguments: " + ex.getMessage());
            return 1;
        }

        String fileName = cmd.getOptionValue("s");

        List<String> positionalArgs = cmd.getArgList();
        if (positionalArgs.isEmpty()) {
            System.err.println("Missing Command");
            return 1;
        }

        String command = positionalArgs.get(0);

        // Get Service
        DataSourceGenerator dataSourceGenerator = new DataSourceGenerator(fileName);
        ToDoService service = dataSourceGenerator.getService();

        // Get Command and Arguments
        if (command.equals("insert") && positionalArgs.size() < 2) {
                System.err.println("Missing TODO name");
                return 1;
        }
        else{
            String todo = positionalArgs.get(1);
            CommandGenerator commandGenerator = new CommandGenerator(command,todo,service);
            CommandService commandService = commandGenerator.getService();
            commandService.execute();
        }

        System.err.println("Done.");
        return 0;
    }
}
