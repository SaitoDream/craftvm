package com.cyslab.craftvm.mongo.impl;

import java.util.Set;

import com.cyslab.craftvm.mongo.MongoCollectionOperations;
import com.cyslab.craftvm.mongo.helper.MongoConfigHelper;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

public class MongoCollectionOperationsImpl implements MongoCollectionOperations {

	@Override
	public DBCollection createCollection(String argDatabaseName,
			String argCollectionName, DBObject argDbObject) {
		DB db = MongoConfigHelper.getInstance().getDb(argDatabaseName);
		return db.createCollection(argCollectionName, argDbObject);
	}

	@Override
	public boolean isCollectionExists(String argDatabaseName,
			String argCollectionName) {
		DB db = MongoConfigHelper.getInstance().getDb(argDatabaseName);
		return db.collectionExists(argCollectionName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.startupoxygen.craft.mongo.MongoCollectionOperations#getCollection
	 * (java.lang.String, java.lang.String)
	 * 
	 * Gets a collection with a given name. If the collection does not exist, a
	 * new collection is created. Follow this link:
	 * "https://groups.google.com/forum/?fromgroups=#!topic/mongodb-user/ll0mf1uqMFo"
	 */
	@Override
	public DBCollection getCollection(String argDatabaseName,
			String argCollectionName) {
		DB db = MongoConfigHelper.getInstance().getDb(argDatabaseName);
		return db.getCollection(argCollectionName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.startupoxygen.craft.mongo.MongoCollectionOperations#
	 * getCollectionFromString(java.lang.String, java.lang.String)
	 * 
	 * See the link
	 * "https://groups.google.com/forum/?fromgroups=#!topic/mongodb-user/ll0mf1uqMFo"
	 */
	@Override
	public DBCollection getCollectionFromString(String argDatabaseName,
			String argCollectionName) {
		DB db = MongoConfigHelper.getInstance().getDb(argDatabaseName);
		return db.getCollectionFromString(argCollectionName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.startupoxygen.craft.mongo.MongoCollectionOperations#getCollectionNames
	 * (java.lang.String)
	 * 
	 * Returns a set of the names of collections in this database.
	 */
	@Override
	public Set<String> getCollectionNames(String argDatabaseName) {
		DB db = MongoConfigHelper.getInstance().getDb(argDatabaseName);
		return db.getCollectionNames();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.startupoxygen.craft.mongo.MongoCollectionOperations#getDatabaseName()
	 * 
	 * Returns the name of this database
	 */
	@Override
	public String getDatabaseName(String argDatabaseName) {
		DB db = MongoConfigHelper.getInstance().getDb(argDatabaseName);
		return db.getName();
	}

	@Override
	public Mongo getMongoInstance() {
		return MongoConfigHelper.getInstance().getMongo();
	}

	@Override
	public CommandResult getDatabaseStats(String argDatabaseName) {
		DB db = MongoConfigHelper.getInstance().getDb(argDatabaseName);
		return db.getStats();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.startupoxygen.craft.mongo.MongoCollectionOperations#getSecondDatabase
	 * (java.lang.String)
	 * 
	 * Return a reference to another database using this same connection. This
	 * allows for cross database queries. Another synonym is "getSisterDB" .
	 * Usage example: db.getSiblingDB('production').getCollectionNames()
	 */
	@Override
	public DB getSecondDatabase(String argSecondaryDatabaseName) {
		DB db = MongoConfigHelper.getInstance().getDb(argSecondaryDatabaseName);
		return db.getSisterDB(argSecondaryDatabaseName);
	}

	@Override
	public boolean isAuthenticated(String argDatabaseName) {
		DB db = MongoConfigHelper.getInstance().getDb(argDatabaseName);
		return db.isAuthenticated();
	}

	@Override
	public void deleteCollection(String argDatabaseName,
			String argCollectionName) {
		DBCollection dbCollection = getCollection(argDatabaseName,
				argCollectionName);
		dbCollection.drop();
	}

}
