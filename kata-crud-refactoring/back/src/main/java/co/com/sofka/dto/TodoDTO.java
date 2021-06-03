package co.com.sofka.dto;

import co.com.sofka.entity.Todo;


public class TodoDTO {

    private Long id;
    private String name;
    private boolean completed;
    private ListTodoDTO listTodoDTO;

    public TodoDTO() {
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

    public TodoDTO(Long id, String name, boolean completed, ListTodoDTO listTodoDTO) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.listTodoDTO = listTodoDTO;
    }

    public co.com.sofka.dto.ListTodoDTO getListTodoDTO() {
        return listTodoDTO;
    }

    public void setListTodoDTO(co.com.sofka.dto.ListTodoDTO listTodoDTO) {
        this.listTodoDTO = listTodoDTO;
    }

    public Todo toTodoDTO(TodoDTO todoDTO) {
        return new Todo(
                todoDTO.id,
                todoDTO.name,
                todoDTO.completed,
                listTodoDTO.toListTodoDTO(todoDTO.getListTodoDTO())
        );
    }
}
