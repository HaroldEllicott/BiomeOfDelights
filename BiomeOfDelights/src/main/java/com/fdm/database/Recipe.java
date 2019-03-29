package com.fdm.database;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity(name = "Recipe")
@Table(name = "recipe")
public class Recipe implements Persistable<Recipe>, Serializable {

	private static final long serialVersionUID = 2909813446197289535L;
	
	@Id
	@Column(name = "recipe_id")
	private int recipe_id;
	private String recipe_name;
	private String recipe_difficulty;
	private String meal_type;
	private String preparation_time;
	private String description;
 
	@OneToMany(mappedBy = "recipe")
	Set<RecipeReviews> reviews;

	@ManyToOne
	@JoinColumn(name = "chef_id")
	Chef chef;

	@Override
	public void update(Recipe persistable) {
		this.recipe_name = persistable.recipe_name;
		this.recipe_difficulty = persistable.recipe_difficulty;
		this.meal_type = persistable.meal_type;
		this.preparation_time = persistable.preparation_time;
		this.description = persistable.description;
	}

	@Column(name = "recipe_id", unique = true, nullable = false)
	@Override
	public int getId() {
		return this.recipe_id;
	}

	public void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}

	@Column(name = "recipe_name", unique = true, nullable = false, length = 50)
	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}

	@Column(name = "recipe_difficulty", unique = true, nullable = false, length = 50)
	public String getRecipe_difficulty() {
		return recipe_difficulty;
	}

	public void setRecipe_difficulty(String recipe_difficulty) {
		this.recipe_difficulty = recipe_difficulty;
	}

	@Column(name = "meal_type", unique = true, nullable = false, length = 50)
	public String getMeal_type() {
		return meal_type;
	}

	public void setMeal_type(String meal_type) {
		this.meal_type = meal_type;
	}

	@Column(name = "preparation_time", unique = true, nullable = false, length = 50)
	public String getPreparation_time() {
		return preparation_time;
	}

	public void setPreparation_time(String preparation_time) {
		this.preparation_time = preparation_time;
	}

	@Column(name = "description", unique = true, nullable = false, length = 255)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public final Chef getChef() {
		return chef;
	}

	public final void setChef(Chef chef) {
		this.chef = chef;
	}

	public final Set<RecipeReviews> getReviews() {
		return reviews;
	}

	public final void setReviews(Set<RecipeReviews> reviews) {
		this.reviews = reviews;
	}

}
