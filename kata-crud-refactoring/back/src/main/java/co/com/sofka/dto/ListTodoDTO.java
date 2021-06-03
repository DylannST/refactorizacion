package co.com.sofka.dto;

import co.com.sofka.entity.ListTodo;


public class ListTodoDTO {

    private Long id;
    private String name;

    public ListTodoDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ListTodoDTO() {
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

    public ListTodo toListTodoDTO(ListTodoDTO listTodoDTO) {
        return new ListTodo(
                listTodoDTO.id,
                listTodoDTO.name
        );
    }
}
