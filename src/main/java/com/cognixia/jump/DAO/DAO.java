package com.cognixia.jump.DAO;

import java.io.Serializable;
import java.util.List;

public interface DAO<T extends Serializable> {
	
	List<T> findAll();
	
	boolean create(T entity);
	
	boolean update(T entity);

	boolean remove(T entity);
}
