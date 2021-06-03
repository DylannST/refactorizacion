package co.com.sofka.entity;

import co.com.sofka.dto.TodoDTO;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "nota")
public class Todo {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean completed;

    public Todo(Long id, String name, boolean completed, ListTodo listTodo) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.listTodo = listTodo;
    }

    public Todo() {

    }


    @JoinColumn(name = "idgroup")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ListTodo listTodo;

    public ListTodo getListTodo() {
        return listTodo;
    }

    public void setListTodo(ListTodo listTodo) {
        this.listTodo = listTodo;
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

    public static TodoDTO toEntityTodo(Todo todo) {
        return new TodoDTO(
                todo.id,
                todo.name,
                todo.completed,
                todo.listTodo.toEntityListTodo(todo.getListTodo())
        );
    }
}
