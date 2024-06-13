package Database;

import java.util.List;
import java.util.Optional;

import Entity.Entity;
import Exception.DatabaseException;

public interface DatabaseTableI<T extends Entity>{
    /* Methods */
	void save(T entity) throws DatabaseException;
    Optional<T> findById(int id) throws DatabaseException;
    List<T> findAll() throws DatabaseException;
    void update(int id, T entity) throws DatabaseException;
    void delete(int id) throws DatabaseException;
}
