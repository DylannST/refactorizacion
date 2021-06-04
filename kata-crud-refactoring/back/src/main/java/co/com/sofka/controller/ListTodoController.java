package co.com.sofka.controller;

import co.com.sofka.dto.ListTodoDTO;
import co.com.sofka.service.ListTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "*")
public class ListTodoController {

    @Autowired
    private ListTodoService listTodoService;

    @GetMapping(value = "api/ListTodos")
    public Iterable<ListTodoDTO> list() {
        return listTodoService.list();
    }

    @PostMapping(value = "api/ListTodos")
    public ListTodoDTO save(@RequestBody ListTodoDTO listTodoDTO) {
        return listTodoService.save(listTodoDTO);
    }

    @PutMapping(value = "api/ListTodos")
    public ListTodoDTO update(@RequestBody ListTodoDTO listTodoDTO) {
        if (listTodoDTO.getId() != null) {
            return listTodoService.save(listTodoDTO);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "api/{id}/ListTodos")
    public void delete(@PathVariable("id") Long id) {
        listTodoService.delete(id);
    }

//    @GetMapping(value = "api/{id}/ListTodos")
//    public ListTodoDTO get(@PathVariable("id") Long id) {
//        return listTodoService.get(id);
//    }

}
