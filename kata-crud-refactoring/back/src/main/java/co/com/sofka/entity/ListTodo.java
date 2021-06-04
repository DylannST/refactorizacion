package co.com.sofka.entity;

import co.com.sofka.dto.ListTodoDTO;

import javax.persistence.*;

@Entity
@Table(name = "lista")
public class ListTodo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public ListTodo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ListTodo() {
    }

    public static ListTodoDTO toEntityListTodo(ListTodo listTodo) {
        return new ListTodoDTO(
                listTodo.id,
                listTodo.name
        );
    }
}
