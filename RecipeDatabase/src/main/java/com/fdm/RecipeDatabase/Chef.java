package com.fdm.RecipeDatabase;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Chef")
@Table(name = "chef")
public class Chef implements Persistable<Chef>, Serializable {

	private static final long serialVersionUID = 2L;

	@Id
	@Column(name = "chef_id")
	private int chef_id;
	private String chef_name;

	public Chef() {
 
	}

	public Chef(int i, String string) {

	}

	@Override
	public int getId() {
		return chef_id;
	}

	public void setChef_id(int chef_id) {
		this.chef_id = chef_id;
	}

	public String getChef_name() {
		return chef_name;
	}

	public void setChef_name(String chef_name) {
		this.chef_name = chef_name;
	}

	@Override
	public void update(Chef persistable) {
		this.chef_name = persistable.chef_name;
	}

}
