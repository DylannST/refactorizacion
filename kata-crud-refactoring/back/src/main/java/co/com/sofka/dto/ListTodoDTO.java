package co.com.sofka.dto;

import co.com.sofka.entity.ListTodo;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lista")
public class ListTodoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public ListTodoDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ListTodoDTO() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static ListTodo toEntityListTodo(ListTodoDTO listTodoDTO) {
        return new ListTodo(
                listTodoDTO.id,
                listTodoDTO.name
        );
    }
}
