package model.dao;

import java.util.List;

import model.entities.Department;

public interface GenericDao<T>{

	public void insert(T obj);
	public void update(T obj);
	public void deleteById(Integer id);
	public Department findById(Integer id);
	public List<T> findAll();
}
