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
    private ListTodo dto = new ListTodo();
    private List<ListTodoDTO> ListTodoDTO = new ArrayList<>();
    private ListTodoDTO listTodoDTOTemporal = new ListTodoDTO();

    public Iterable<ListTodoDTO> list() {
        Iterable<ListTodo> dtoAuxiliar = repository.findAll();
        dtoAuxiliar.forEach(x -> ListTodoDTO.add(dto.toEntityListTodo(x)));
        return ListTodoDTO;
    }

    public ListTodoDTO save(ListTodoDTO listTodoDTO) {
        return dto.toEntityListTodo(repository.save(listTodoDTO.toListTodoDTO(listTodoDTO)));
    }

    public void delete(Long id) {
        repository.delete(listTodoDTOTemporal.toListTodoDTO(get(id)));
    }

    public ListTodoDTO get(Long id) {
        return dto.toEntityListTodo(repository.findById(id).orElseThrow());
    }
}
