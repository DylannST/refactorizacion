package co.com.sofka.entity;

import co.com.sofka.dto.TodoDTO;


public class Todo {

    private Long id;
    private String name;
    private boolean completed;
    private Long idGroup;

    public Long getIdGroup() {
        return idGroup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Todo(Long id, String name, boolean completed, Long idGroup) {
        this.id = id;
        this.name = name;
        this.completed = completed;
    }


    public TodoDTO toTodoDTO(Todo todo) {
        return new TodoDTO(
                todo.id,
                todo.name,
                todo.completed,
                todo.idGroup
        );
    }
}
