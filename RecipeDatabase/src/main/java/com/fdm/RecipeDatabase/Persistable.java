package com.fdm.RecipeDatabase;

public interface Persistable <T extends Persistable> {
	int getId();
	void update(T persistable);

}
