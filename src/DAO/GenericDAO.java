package DAO;

import Entity.Entity;

import java.util.List;
import java.util.Optional;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.function.Predicate;

import Database.Database;
import Exception.DAOException;
import Exception.DatabaseException;

public class GenericDAO<T extends Entity> implements DAO<T> {
    /* Atributes */
    private Class<T> clazz;
    private Database database = Database.getInstance();
    
    /* Methods */
	public void save(T entity) throws DAOException{
        try{
            database.save(entity.getClass(), entity);
        } catch (DatabaseException e){
            throw new DAOException(e.getMessage());
        }
    }

    public Optional<T> findById(int id) throws DAOException{
        try{
            return database.findById(clazz, id);
        } catch (DatabaseException e){
            throw new DAOException(e.getMessage());
        }  
    }

    public List<T> findAll() throws DAOException{
        try{
            return database.findAll(clazz);
        } catch (DatabaseException e){
            throw new DAOException(e.getMessage());
        }
    }

    public List<T> findAll(Predicate<T> filter) throws DAOException{
        try{
            List<T> list = database.findAll(clazz);
            return  list.stream()
                        .filter(filter)
                        .collect(Collectors.toList());
        } catch (DatabaseException e){
            throw new DAOException(e.getMessage());
        }

    }

    public List<T> findAll(Comparator<T> comparator) throws DAOException{
        try{
            List<T> list = database.findAll(clazz);
            return  list.stream()
                        .sorted(comparator)
                        .collect(Collectors.toList());
        } catch (DatabaseException e){
            throw new DAOException(e.getMessage());
        }
    }

    public void update(int id, T entity) throws DAOException{
        try{
            database.update(clazz, id, entity);
        }
        catch (DatabaseException e){
            throw new DAOException(e.getMessage());
        }
    }
    
    public void delete(int id) throws DAOException{
        try{
            database.delete(clazz, id);
        } catch (DatabaseException e){
            throw new DAOException(e.getMessage());
        }
    }
}

