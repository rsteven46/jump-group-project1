package com.cognixia.jump.DAO;

import java.io.Serializable;
import java.util.List;

public interface DAO<T extends Serializable> {
	
	T findById(long id);
	
	T findByName(String name);
	
	List<T> findAll();
	
	boolean addStatus(T entity);
	
	boolean updateStatus(T entity);
	
}
