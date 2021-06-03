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
    private Todo dto = new Todo();
    private List<TodoDTO> todoDTO = new ArrayList<>();
    private TodoDTO todoDTOTemporal = new TodoDTO();


    public Iterable<TodoDTO> list() {
        Iterable<Todo> dtoAuxiliar = repository.findAll();
        dtoAuxiliar.forEach(x -> todoDTO.add(dto.toEntityTodo(x)));
        return todoDTO;
    }

    public TodoDTO save(TodoDTO todoDTO) {
        repository.save(todoDTO.toTodoDTO(todoDTO));
        return todoDTO;
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }

    public TodoDTO get(Long id) {
        return dto.toEntityTodo(repository.findById(id).orElseThrow());
    }

}
