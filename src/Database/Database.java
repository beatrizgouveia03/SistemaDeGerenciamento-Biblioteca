package Database;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Optional;

import Entity.Entity;
import Exception.DatabaseException;

public class Database {
    /* Attributes */
    private Map<Class<? extends Entity>, DatabaseTableI<? extends Entity>> tables = new HashMap<>();
    private static Database instance;

    /* Constructor */
    public Database() {
        this.tables = new HashMap<>();
    }

    /* Methods */
	public <T extends Entity> void save(Class<? extends Entity> class1, T entity) throws DatabaseException {
        if (!tables.containsKey(class1)) {
            tables.put(class1, new DatabaseTable<>());
        }

        DatabaseTableI<? extends Entity> table = tables.get(class1);
        ((DatabaseTableI<T>) table).save(entity);
    }
    public <T extends Entity> Optional<T> findById(Class<T> clazz, int id) throws DatabaseException{
        if(!tables.containsKey(clazz)){
            tables.put(clazz, new DatabaseTable<>());
        } 

        DatabaseTableI<? extends Entity> table = tables.get(clazz);
        return ((DatabaseTableI<T>) table).findById(id);
    }

    public <T extends Entity> List<T> findAll(Class<T> clazz) throws DatabaseException{
        if(!tables.containsKey(clazz)){
            tables.put(clazz, new DatabaseTable<>());
        } 

        DatabaseTableI<? extends Entity> table = tables.get(clazz);
        return ((DatabaseTableI<T>) table).findAll();
    }

    public <T extends Entity> void update(Class<T> clazz, int id, T entity) throws DatabaseException{
        if(!tables.containsKey(clazz)){
            tables.put(clazz, new DatabaseTable<>());
        } 
    
        DatabaseTableI<? extends Entity> table = tables.get(clazz);
        ((DatabaseTableI<T>) table).update(id, entity);
    }

    public <T extends Entity> void delete(Class<T> clazz, int id) throws DatabaseException{
        if(!tables.containsKey(clazz)){
            tables.put(clazz, new DatabaseTable<>());
        } 
        
        DatabaseTableI<? extends Entity> table = tables.get(clazz);
        ((DatabaseTableI<T>) table).delete(id);
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }

        return instance;
    }
}
