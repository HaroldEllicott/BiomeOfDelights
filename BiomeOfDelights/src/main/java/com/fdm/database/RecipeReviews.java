package com.fdm.database;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "RecipeReviews")
@Table(name = "recipe_reviews")
//@SequenceGenerator(name = "sequence", initialValue = 1)
public class RecipeReviews implements Persistable<RecipeReviews>, Serializable {

	private static final long serialVersionUID = 5239687627158729691L;
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
	@Id
	int review_id;

	@ManyToOne
	@JoinColumn(name = "recipe_id")
	Recipe recipe;
	
	@ManyToOne
	@JoinColumn(name = "reviewer_id")
	Reviewer reviewer;

	String review;
 
	public RecipeReviews() {
	}

	public RecipeReviews(String review, int review_id) {
		this.review = review;
		this.review_id = review_id;
	}

	@Override
	public int getId() {
		return review_id;
	}

	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public void update(RecipeReviews persistable) {
		this.review = persistable.review;
	}


}
