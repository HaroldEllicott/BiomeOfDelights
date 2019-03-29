package com.fdm.database;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RecipeReviewsKey implements Serializable{

	private static final long serialVersionUID = 7326398105949481658L;
	
	@Column(name = "recipe_id")
	 int recipe_id;
	
	@Column(name = "reviewer_id")
	  int reviewer_id;

	public RecipeReviewsKey() {
		
	}
	
	public RecipeReviewsKey(int recipe_id, int reviewer_id) {
		this.recipe_id = recipe_id;
		this.reviewer_id = reviewer_id;
	}

	public final int getRecipe_id() {
		return recipe_id;
	}

	public final void setRecipe_id(int recipe_id) {
		this.recipe_id = recipe_id;
	}

	public final int getReviewer_id() {
		return reviewer_id;
	}

	public final void setReviewer_id(int reviewer_id) {
		this.reviewer_id = reviewer_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + recipe_id;
		result = prime * result + reviewer_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipeReviewsKey other = (RecipeReviewsKey) obj;
		if (recipe_id != other.recipe_id)
			return false;
		if (reviewer_id != other.reviewer_id)
			return false;
		return true;
	}

}
