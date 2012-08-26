package com.cyslab.craftvm.mongo;

import java.util.Set;

import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public interface MongoCollectionOperations {

	public DBCollection createCollection(String argDatabaseName,
			String argCollectionName, DBObject argDbObject);

	public boolean isCollectionExists(String argDatabaseName,
			String argCollectionName);

	public DBCollection getCollection(String argDatabaseName,
			String argCollectionName);

	public DBCollection getCollectionFromString(String argDatabaseName,
			String argCollectionName);

	public Set<String> getCollectionNames(String argDatabaseName);

	public String getDatabaseName(String argDatabaseName);

	public Mongo getMongoInstance();

	public CommandResult getDatabaseStats(String argDatabaseName);

	public DB getSecondDatabase(String argSecondaryDatabaseName);

	public boolean isAuthenticated(String argDatabaseName);

	public void deleteCollection(String argDatabaseName,
			String argCollectionName);
}
