package Database;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Optional;
import java.util.ArrayList;

import Entity.Entity;
import Exception.DatabaseException;
import Exception.EntityNotFoundException;

public class DatabaseTable<T extends Entity> implements DatabaseTableI<T> {
	/* Attributes */
	private Integer idGenerator;
	private Map<Integer, T> table = new HashMap<>();

	/* Methods */
	public int generateId(){
		return this.idGenerator++;
	}

	@Override
	public void save(T entity) throws DatabaseException{
		int id = generateId();
		entity.setId(id);
		this.table.put(id,entity);
	}

	@Override
	public Optional<T> findById(int id) throws DatabaseException {
		if(this.table.containsKey(id)){
			return Optional.of(this.table.get(id));
		} else{
			throw new EntityNotFoundException("Entity not found in search!");
		}
	}

	@Override
	public List<T> findAll() throws DatabaseException{
		if(this.table.isEmpty()){
			throw new DatabaseException("No data found");
		}

		List<T> list = new ArrayList<>();

		for(Integer id : this.table.keySet()){
			list.add(this.table.get(id));
		}

		return list;
	}


	@Override
	public void update(int id, T updatedEntity) throws DatabaseException{
		if(this.table.containsKey(id)){
			this.table.put(id, updatedEntity);
		} else{
			throw new EntityNotFoundException("Entity to be updated not found!");
		}
	}

	@Override
	public void delete(int id) throws DatabaseException{
		if(this.table.containsKey(id)){
			this.table.remove(id);
		} else {
			throw new EntityNotFoundException("Entity to be removed not found!");
		}

	}

}
