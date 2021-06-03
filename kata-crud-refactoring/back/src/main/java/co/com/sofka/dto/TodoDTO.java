package co.com.sofka.dto;

import co.com.sofka.entity.Todo;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "nota")
public class TodoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean completed;

    public TodoDTO(Long id, String name, boolean completed, Long idGroup) {
        this.id = id;
        this.name = name;
        this.completed = completed;
        this.listTodoDTO.setId(idGroup);
    }

    public TodoDTO() {

    }


    @JoinColumn(name = "id_group")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ListTodoDTO listTodoDTO;

    public ListTodoDTO getListTodoDTO() {
        return listTodoDTO;
    }

    public void setListTodoDTO(ListTodoDTO listTodoDTO) {
        this.listTodoDTO = listTodoDTO;
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

    public static Todo toEntityTodo(TodoDTO todoDTO) {
        return new Todo(
                todoDTO.id,
                todoDTO.name,
                todoDTO.completed,
                todoDTO.getListTodoDTO().getId()
        );
    }
}
