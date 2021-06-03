package co.com.sofka.controller;

import co.com.sofka.entity.ListTodo;
import co.com.sofka.service.ListTodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "*")
public class ListTodoController {

    @Autowired
    private ListTodoService listTodoService;

    @GetMapping(value = "api/ListTodos")
    public Iterable<ListTodo> list() {
        return listTodoService.list();
    }

    @PostMapping(value = "api/ListTodos")
    public ListTodo save(@RequestBody ListTodo listTodo) {
        return listTodoService.save(listTodo);
    }

    @PutMapping(value = "api/ListTodos")
    public ListTodo update(@RequestBody ListTodo listTodo) {
        if (listTodo.getId() != null) {
            return listTodoService.save(listTodo);
        }
        throw new RuntimeException("No existe el id para actualziar");
    }

    @DeleteMapping(value = "api/{id}/ListTodos")
    public void delete(@PathVariable("id") Long id) {
        listTodoService.delete(id);
    }

    @GetMapping(value = "api/{id}/ListTodos")
    public ListTodo get(@PathVariable("id") Long id) {
        return listTodoService.get(id);
    }
}
