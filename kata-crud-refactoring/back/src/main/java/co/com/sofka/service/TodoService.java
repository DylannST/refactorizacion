package co.com.sofka.service;

import co.com.sofka.dto.TodoDTO;
import co.com.sofka.entity.Todo;
import co.com.sofka.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;
    private TodoDTO dto;
    private List<Todo> todo;
    private Todo todoTemporal;


    public Iterable<Todo> list() {
        Iterable<TodoDTO> dtoAuxiliar = repository.findAll();
        dtoAuxiliar.forEach(x -> todo.add(dto.toEntityTodo(x)));
        return todo;
    }

    public Todo save(Todo todo) {
        repository.insert(todo.getName(), todo.isCompleted(), todo.getId());
        return todo;
    }


    public void delete(Long id) {
        repository.delete(todoTemporal.toTodoDTO(get(id)));
    }

    public Todo get(Long id) {
        return dto.toEntityTodo(repository.findById(id).orElseThrow());
    }

}
