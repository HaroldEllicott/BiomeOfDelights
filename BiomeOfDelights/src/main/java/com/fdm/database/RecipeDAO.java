package com.fdm.database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class RecipeDAO <T extends Persistable> {

	private final EntityManagerFactory emf;
	private final Class<T> clazz;
	
	public RecipeDAO(EntityManagerFactory emf, Class<T> clazz) {
		this.emf = emf;
		this.clazz = clazz;
	}
	
	public void add(T persistable) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(persistable); 
		transaction.commit(); 
		manager.close();
	}

	public T get(int id) {
		EntityManager manager = emf.createEntityManager();
		T found = manager.find(clazz, id);
		manager.close();
		return found;
	}

	public void update(T persistable) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		T found = manager.find(clazz, persistable.getId());
		found.update(persistable);
		transaction.commit();
		manager.close();
		
	}

	public void delete(T persistable) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		T found = manager.find(clazz, persistable.getId());
		manager.remove(found);
		transaction.commit();
		manager.close();
		
	}
	
	public List<T> getAll(T persistable) {
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery(
				"SELECT e FROM T e", Persistable.class);

		List<T> allRecipes = query.getResultList();
		return  allRecipes;

	}

}
