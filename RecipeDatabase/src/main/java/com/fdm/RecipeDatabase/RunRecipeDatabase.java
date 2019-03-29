package com.fdm.RecipeDatabase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RunRecipeDatabase {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracleDBconnect");
		
		RecipeDAO<Recipe> recipeDAO = new RecipeDAO<> (emf, Recipe.class);
		Recipe recipe = new Recipe();
		recipe.setRecipe_id(1); 
		recipe.setRecipe_name("Cranberry Squash Muffins");
		recipe.setRecipe_difficulty("Easy");
		recipe.setPreparation_time("30 minutes");
		recipe.setMeal_type("Breakfast/Snack");
		recipe.setDescription("Delicious, moist treat with zingy cranberry bites.");
		recipeDAO.add(recipe);
		
		RecipeDAO<Reviewer> reviewerDAO = new RecipeDAO<> (emf, Reviewer.class);
		Reviewer reviewer = new Reviewer();
		reviewer.setReviewer_id(1);
		reviewer.setUsername("EatsMelons4Breakfast");
		reviewerDAO.add(reviewer);
		
		RecipeDAO<RecipeReviews> recipeReviewsDAO = new RecipeDAO<> (emf, RecipeReviews.class);
		RecipeReviews recipeReviews = new RecipeReviews();
		recipeReviews.setReview("5");
		recipeReviews.setReview_id(1);
		recipeReviewsDAO.add(recipeReviews);
		
		RecipeDAO<Chef> chefDAO = new RecipeDAO<> (emf, Chef.class);
		Chef chef = new Chef();
		chef.setChef_id(1);
		chef.setChef_name("Shirley Plant");
		chefDAO.add(chef);
		
		System.out.println(recipeDAO.getAll());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
