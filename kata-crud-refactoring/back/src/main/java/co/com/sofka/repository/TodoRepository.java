package co.com.sofka.repository;

import co.com.sofka.entity.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

    @Query(value = "SELECT * FROM nota where idgroup=?1", nativeQuery = true)
    public abstract Iterable<Todo> findByFkId(Long id);
}
