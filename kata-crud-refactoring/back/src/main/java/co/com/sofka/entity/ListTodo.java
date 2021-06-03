package co.com.sofka.entity;

import co.com.sofka.dto.ListTodoDTO;


public class ListTodo {

    private Long id;
    private String name;

    public ListTodo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ListTodo() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ListTodoDTO toListTodoDTO(ListTodo listTodo) {
        return new ListTodoDTO(
                listTodo.id,
                listTodo.name
        );
    }
}
