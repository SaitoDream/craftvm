package com.cyslab.craft.mongo;

import java.util.Collection;
import java.util.List;

import com.mongodb.DB;

public interface MongoDatabaseOperations {

	public DB createDataBase(String argDatabaseName);

	public void dropDatabase(String argDatabaseName);

	public List<String> getDatabaseNames();

	public DB getDB(String argDatabaseName);

	public Collection<DB> getUsedDatabases();
}
