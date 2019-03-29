package com.fdm.database;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity(name = "Reviewer")
@Table(name = "reviewer")
public class Reviewer implements Persistable<Reviewer> {
	@Id
	@Column(name = "reviewer_id")
	private int reviewer_id;
	private String username;
	
	public Reviewer() {

	} 

	public Reviewer(Reviewer persistable) {
		this.reviewer_id = persistable.reviewer_id;
		this.username = persistable.username;
	}

	@Override
	public void update(Reviewer persistable) {
		this.username = persistable.username;
	}

	@Column(name = "reviewer_id", unique = true, nullable = false)
	@Override
	public int getId() {
		return this.reviewer_id;
	}

	public void setReviewer_id(int reviewer_id) {
		this.reviewer_id = reviewer_id;
	}

	@Column(name = "username", unique = true, nullable = false, length = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
