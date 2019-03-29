package com.fdm.RecipeDatabase;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class ChefTest {
	
	private final EntityManagerFactory emf = mock(EntityManagerFactory.class);
	private final EntityManager manager = mock(EntityManager.class);
	private final EntityTransaction transaction = mock(EntityTransaction.class);
	private final RecipeDAO<Chef> dao = new RecipeDAO<>(emf, Chef.class);
	Chef chef = new Chef();
	
	@Test
	public void when_getId_called_returns_chef_id() {
		chef.setChef_id(1);
		
		assertEquals(1, chef.getId());
	}
	
	@Test
	public void when_getChef_name_called_returns_chef_name() {
		chef.setChef_name("Shirley Plant");
		
		assertEquals("Shirley Plant", chef.getChef_name());
	}
	//How to test this? This is confusing to me. The set is a set of Recipe, NOT chef, so how do I test it in the context of Chef??
	@Test
	public void when_getRecipes_called_returns_recipe_set() {
		Chef chef1 = new Chef(1, "Bill");
		Set<Recipe> recipes = new HashSet<>();
		//recipes.add(chef1);
		chef.setRecipes(recipes);
		
		assertEquals("Shirley Plant", chef.getChef_name());
	}
	
	@Test
	public void on_update_gets_new_chef_name_and_updates_database_chef_name() {
		when(emf.createEntityManager()).thenReturn(manager);
		when(manager.getTransaction()).thenReturn(transaction);
		Chef persistable = mock(Chef.class);
		Chef found = mock(Chef.class);
		when(manager.find(Chef.class, 5)).thenReturn(found);
		when(persistable.getId()).thenReturn(5);
		
		dao.update(persistable);
		
		InOrder order = inOrder(emf, manager, transaction, found);
		order.verify(emf).createEntityManager();
		order.verify(manager).getTransaction();
		order.verify(transaction).begin();
		order.verify(manager).find(Chef.class, 5);
		order.verify(found).update(persistable);
		order.verify(manager).close();
		
	}
}
