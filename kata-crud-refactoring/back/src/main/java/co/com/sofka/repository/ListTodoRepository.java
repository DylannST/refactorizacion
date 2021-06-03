package co.com.sofka.repository;

import co.com.sofka.entity.ListTodo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListTodoRepository extends CrudRepository<ListTodo, Long> {
}
