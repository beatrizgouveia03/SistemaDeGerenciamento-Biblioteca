package Database;

import java.util.Map;
import java.util.Optional;
import java.util.HashMap;
import java.util.List;

import Entity.Entity;
import Exception.DatabaseException;

public class Database {
    /* Atributes */
    Map<Class<? extends Entity>, DatabaseTableI<? extends Entity>> tables;

    /* Cosntructor */
    public Database() {
        this.tables = new HashMap<>();
    }

    /* Methods */
	public <T extends Entity> void save(Class<T> clazz, T entity) throws DatabaseException{
        if (!tables.containsKey(clazz)) {
            tables.put(clazz, new DatabaseTable<>());
        }

        tables.get(clazz).save(entity);
    }
    <T extends Entity> Optional<? extends Entity> findById(Class<T> clazz, int id) throws DatabaseException{
        if(!tables.containsKey(clazz)){
            tables.put(clazz, new DatabaseTable<>());
        } 

        return this.tables.get(clazz).findById(id);
    }

    <T extends Entity> List<? extends Entity> findAll(Class<T> clazz) throws DatabaseException{
        if(!tables.containsKey(clazz)){
            tables.put(clazz, new DatabaseTable<>());
        } 

        return this.tables.get(clazz).findAll();
    }

    <T extends Entity> void update(Class<T> clazz, int id, T entity) throws DatabaseException{
        if(!tables.containsKey(clazz)){
            tables.put(clazz, new DatabaseTable<>());
        } 
    
        this.tables.get(clazz).update(id, entity);
    }

    <T extends Entity> void delete(Class<T> clazz, int id) throws DatabaseException{
        if(!tables.containsKey(clazz)){
            tables.put(clazz, new DatabaseTable<>());
        } 
        
        this.tables.get(clazz).delete(id);
    }
    

}
