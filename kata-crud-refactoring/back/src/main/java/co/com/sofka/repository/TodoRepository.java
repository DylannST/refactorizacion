package co.com.sofka.repository;

import co.com.sofka.dto.TodoDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<TodoDTO, Long> {

    @Query(value = "insert INTO nota (id, name,completed,id_group) VALUES (null,?1,:?2,:?3)", nativeQuery = true)
    public abstract void insert(String name, boolean completed, Long id);
}
