package co.com.sofka.repository;

import co.com.sofka.dto.ListTodoDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListTodoRepository extends CrudRepository<ListTodoDTO, Long> {
}
