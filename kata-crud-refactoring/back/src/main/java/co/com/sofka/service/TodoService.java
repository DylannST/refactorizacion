package co.com.sofka.service;

import co.com.sofka.dto.TodoDTO;
import co.com.sofka.entity.Todo;
import co.com.sofka.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;


    public Iterable<TodoDTO> list() {
        List<TodoDTO> todoDTO = new ArrayList<>();
        Iterable<Todo> dtoAuxiliar = repository.findAll();
        dtoAuxiliar.forEach(x -> todoDTO.add(Todo.toEntityTodo(x)));
        return todoDTO;
    }

    public TodoDTO save(TodoDTO todoDTO) {
       // repository.save(todoDTO.toTodoDTO(todoDTO));
        return Todo.toEntityTodo(repository.save(todoDTO.toTodoDTO(todoDTO)));
        //return todoDTO;
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }

    public TodoDTO get(Long id) {
        return Todo.toEntityTodo(repository.findById(id).orElseThrow());
    }

    public Iterable<TodoDTO> listByIdFk(Long id) {
        List<TodoDTO> todoDTON = new ArrayList<>();
        Iterable<Todo> dtoAuxiliar = repository.findByFkId(id);
        dtoAuxiliar.forEach(x -> todoDTON.add(Todo.toEntityTodo(x)));
        return todoDTON;
    }
}
