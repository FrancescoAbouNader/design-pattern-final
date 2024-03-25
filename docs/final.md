# L3 Final TP Report

- **Firstname**: Francesco
- **Lastname**: Abou Nader

---


## 1. Code Structure and Schema
The code is represented by the following schema:  

***SCHEMA***

---

## 2. SOLID Architecture Implementation
### a. SRP: Single Responsibility Principle
To achieve this principle we create Service Classes specific for each datasource, example:
* **CSVService** for CSV related operations
* **JSONService** for JSON related operations  

As well for Commands:
* **InsertCommand** for insert
* **ListCommand** for listing
* **MigrateCommand** for copying from data source to another  

Along with 2 Data Models:
* **ToDoItem** containing all ToDo Single Item Attributes  
* **ToDoList** containing List of ToDo Items  

By doing that, each class will have only 1 responsibility therefor achieving
the principle.

### b. OCP: Open-Closed Principle
In this case we one interface that contains 2 shared methods 
that are required by all the data sources but with different implementation for each.  

Interface: **ToDoInterface**  
Methods:
* **getToDos**: return all ToDos in data source
* **saveToDo**: to insert into data source

Another interface for commands that contains one shared method required by al commands
but with different implementations:  

Interface: **CommandInterface**  
Method:
* **execute**: that will either migrate data from a source to another, insert data, list data.
### c. LSP: Liskov Substitution Principle
For this principle to be achieved we have an abstract class that can be generally accessed throughout the
program without being affected, example:
* **CommandService** an abstract class that is inherited by **InsertCommand** and **ListCommand**
* **ToDoService** an abstract class that is inherited by **JSONService** and **CSVService**  

Example this will be valid:
* ToDoService service = new JSONService();
* CommandService command = new InsertCommand();
### d. ISP: Interface Segregation Principle
Having 2 different interfaces each having a specific methods achieves this principle, we can also enhance it by
having more specific interfaces to be implemented by a single class to avoid having
unsupported methods.

### e. DIP: Dependency Inversion Principle
By passing through the 2 abstract classes **ToDoService** and **CommandService**
both entities are never directly dependent.  

JSONService --> ToDoService <-- ToDoInterface  
InsertCommand --> CommandService <-- CommandInterface  

Class ***Extends*** Abstract Class ***Implements*** Interface

---

## 3. Dynamic Extensions (Data Source, Commands, Arguments...) 
### a. Adding Command
To add a Command all that is needed to be done is the following:
- Create a new Class, example **WebCommand** that extends **CommandService** abstract class
- Add Code Logic to implemented method execute
- Add the needed info to the Configuration.yaml file in the commands key.

### b. Adding Data Source
To add a data source it is similar to the commands as following:
- Create a new Class, example **XMLService** that extends **ToDoService** abstract class
- Add Code Logic to implemented methods *saveToDo* and *getToDos*
- Add the needed info to the Configuration.yaml file in the commands key.

### c. Adding Attributes
To add attributes all that is required is to add this attribute to the Data Model
and generate its getters and setters.  
Example:  
Adding a Category Attribute to the ToDoItem will look as following:
```java
public class ToDoItem {

    // Model Attributes
    private String toDoItemName;
    private boolean toDoStatus;
    private String toDoCategory;

    // Main Constructor
    public ToDoItem(String toDoItemName, boolean toDoStatus, String toDoCategory) {
        this.toDoItemName = toDoItemName;
        this.toDoStatus = toDoStatus;
        this.toDoCategory = toDoCategory;
    }

    // Getters and Setters
    public String getToDoItemCategory() {
        return toDoCategory;
    }

    public void setToDoItemCategory(String toDoCategory) {
        this.toDoCategory = toDoCategory;
    }
}
```

Finally fix up the visualization method *toString* to print category as well:
```java
    public String toString() {
        if(toDoStatus){
            return "Done: " + toDoItemName + "["+toDoCategory+"]";
        }
        else{
            return toDoItemName + "["+toDoCategory+"]";
        }
    }
```
---

## 4. Support
For any questions please feel free to contact me through email:  
<francescoabounader@gmail.com>