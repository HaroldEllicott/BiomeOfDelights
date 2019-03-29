package com.fdm.RecipeDatabase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import org.junit.Test;
import org.mockito.InOrder;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

public class RecipeDAOTest { 

	private final EntityManagerFactory emf = mock(EntityManagerFactory.class);
	private final EntityManager manager = mock(EntityManager.class);
	private final EntityTransaction transaction = mock(EntityTransaction.class);
	private final RecipeDAO<Persistable> dao = new RecipeDAO<>(emf, Persistable.class);
	
	@Test
	public void when_add_called_persists_Persistable_to_database() {
		when(emf.createEntityManager()).thenReturn(manager); 
		when(manager.getTransaction()).thenReturn(transaction);
		Persistable persistable = mock(Persistable.class);
		
		dao.add(persistable);
		
		InOrder order = inOrder(emf, manager, transaction);
		order.verify(emf).createEntityManager();
		order.verify(manager).getTransaction();
		order.verify(transaction).begin();
		order.verify(manager).persist(persistable);
		order.verify(transaction).commit();
		order.verify(manager).close();
	}
	
	@Test 
	public void when_get_called_returns_persistable_from_database() {
		when(emf.createEntityManager()).thenReturn(manager);
		Persistable persistable = mock(Persistable.class);
		when(manager.find(Persistable.class, 5)).thenReturn(persistable);
		
		Persistable daopersistable = dao.get(5);
		
		assertSame(persistable, daopersistable);
		InOrder order = inOrder(emf, manager);
		order.verify(emf).createEntityManager();
		order.verify(manager).find(Persistable.class, 5);
		order.verify(manager).close();
	}
	
	@Test
	public void on_update_gets_managed_entity_and_sets_new_id() {
		when(emf.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);
		Persistable persistable = mock(Persistable.class);
		Persistable found = mock(Persistable.class);
		when(manager.find(Persistable.class, 5)).thenReturn(found);
		when(persistable.getId()).thenReturn(5);
		
		dao.update(persistable);
		
		InOrder order = inOrder(emf, manager, transaction, found);
		order.verify(emf).createEntityManager();
		order.verify(manager).getTransaction();
		order.verify(transaction).begin();
		order.verify(manager).find(Persistable.class, 5);
		order.verify(found).update(persistable);
		order.verify(manager).close();
	}
	
	@Test
	public void on_delete_persistable_removed_from_database() {
		when(emf.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);
		Persistable persistable = mock(Persistable.class);
		Persistable found = mock(Persistable.class);
		when(manager.find(Persistable.class, 5)).thenReturn(found);
		when(persistable.getId()).thenReturn(5);
		
		dao.delete(persistable);
		
		InOrder order = inOrder(emf, manager, transaction, found);
		order.verify(emf).createEntityManager();
		order.verify(manager).getTransaction();
		order.verify(transaction).begin();
		order.verify(manager).find(Persistable.class, 5);
		order.verify(manager).remove(found);
		order.verify(manager).close();
		
	}
	
//	@Test
//	public void when_getAll_called_return_all_entries_of_target_entity() {
//		when(emf.createEntityManager()).thenReturn(manager);
//		Persistable persistable = mock(Persistable.class);
//		
//		Persistable daopersistable = dao.getAll();
//		
//		assertSame(persistable, daopersistable);
//		InOrder order = inOrder(emf, manager);
//		order.verify(emf).createEntityManager();
//		order.verify(manager).find(Persistable.class, 5);
//		order.verify(manager).close();
//	}
	
}
