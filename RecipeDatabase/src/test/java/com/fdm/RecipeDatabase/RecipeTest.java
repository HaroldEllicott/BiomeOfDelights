package com.fdm.RecipeDatabase;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Test;
import org.mockito.InOrder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;



public class RecipeTest {
	
	private final EntityManagerFactory emf = mock(EntityManagerFactory.class);
	private final EntityManager manager = mock(EntityManager.class);
	private final EntityTransaction transaction = mock(EntityTransaction.class);
	private final RecipeDAO<Recipe> dao = new RecipeDAO<>(emf, Recipe.class);
	Recipe recipe = new Recipe();
	
	@Test
	public void when_getId_called_return_recipe_id() {
		recipe.setRecipe_id(1);
		
		assertEquals(1, recipe.getId());
	}
	
	@Test
	public void when_getRecipe_name_called_return_recipe_name() {
		recipe.setRecipe_name("Mama's Delicious Pasta Salad");
		
		assertEquals("Mama's Delicious Pasta Salad", recipe.getRecipe_name());
	}
	
	@Test
	public void when_getRecipe_difficulty_called_return_recipe_difficulty() {
		recipe.setRecipe_difficulty("Easy");
		
		assertEquals("Easy", recipe.getRecipe_difficulty());
	}
	
	@Test
	public void when_getMeal_type_called_return_Meal_type() {
		recipe.setMeal_type("Lunch/Dinner");
		
		assertEquals("Lunch/Dinner", recipe.getMeal_type());
	}
	
	@Test
	public void when_getPreparation_time_called_return_Preparation_time() {
		recipe.setPreparation_time("30 mins");
		
		assertEquals("30 mins", recipe.getPreparation_time());
	}
	
	@Test
	public void when_getDescription_called_return_Description() {
		recipe.setDescription("Delicious vegan, optionally gluten-free pasta dish with fresh cut veggies.");
		
		assertEquals("Delicious vegan, optionally gluten-free pasta dish with fresh cut veggies.", recipe.getDescription());
	}
	
	@Test
	public void when_getChef_called_return_chef() {
		Chef newchef = new Chef();
		recipe.setChef(newchef);
		
		assertEquals(newchef, recipe.getChef());
	}
	//How to Test??
	@Test
	public void when_getReviews_called_return_reviews_from_set_RecipeReviews() {
		
	}

	@Test
	public void on_update_gets_new_chef_name_and_updates_database_chef_name() {
		Recipe recipe1 = new Recipe();
		Recipe recipe2 = new Recipe();
		recipe1.setRecipe_name("Cranberry Muffins");
		recipe1.setRecipe_id(1);
		recipe2.setRecipe_name("Sultana Muffins");
		recipe2.setRecipe_id(2);
		assertEquals("Cranberry Muffins", recipe1.getRecipe_name());
		recipe1.update(recipe2);
		assertEquals("Sultana Muffins", recipe2.getRecipe_name());
	}
}
