package com.fdm.database;

public interface Persistable <T extends Persistable> {
	int getId();
	void update(T persistable);

}
