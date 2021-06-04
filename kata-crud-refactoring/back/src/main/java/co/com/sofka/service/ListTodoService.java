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

    public Iterable<ListTodoDTO> list() {
        List<ListTodoDTO> ListTodoDTO = new ArrayList<>();
        Iterable<ListTodo> dtoAuxiliar = repository.findAll();
        dtoAuxiliar.forEach(x -> ListTodoDTO.add(ListTodo.toEntityListTodo(x)));
        return ListTodoDTO;
    }

    public ListTodoDTO save(ListTodoDTO listTodoDTO) {
        return ListTodo.toEntityListTodo(repository.save(listTodoDTO.toListTodoDTO(listTodoDTO)));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public ListTodoDTO get(Long id) {
        return ListTodo.toEntityListTodo(repository.findById(id).orElseThrow());
    }
}
