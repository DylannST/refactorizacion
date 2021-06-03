package co.com.sofka.service;

import co.com.sofka.dto.ListTodoDTO;
import co.com.sofka.entity.ListTodo;
import co.com.sofka.repository.ListTodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListTodoService {
    @Autowired
    private ListTodoRepository repository;

    private ListTodoDTO dto = new ListTodoDTO();
    private List<ListTodo> ListTodo = new ArrayList<>();
    private ListTodo ListTodoTemporal = new ListTodo();

    public Iterable<ListTodo> list() {
        Iterable<ListTodoDTO> dtoAuxiliar = repository.findAll();
        dtoAuxiliar.forEach(x -> ListTodo.add(dto.toEntityListTodo(x)));
        return ListTodo;
    }

    public ListTodo save(ListTodo listTodo) {
        return dto.toEntityListTodo(repository.save(listTodo.toListTodoDTO(listTodo)));
    }

    public void delete(Long id) {
        repository.delete(ListTodoTemporal.toListTodoDTO(get(id)));
    }

    public ListTodo get(Long id) {
        return dto.toEntityListTodo(repository.findById(id).orElseThrow());
    }
}
