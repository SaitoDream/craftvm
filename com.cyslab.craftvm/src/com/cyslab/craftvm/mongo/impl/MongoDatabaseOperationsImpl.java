package com.cyslab.craftvm.mongo.impl;

import java.util.Collection;
import java.util.List;

import com.cyslab.craftvm.mongo.MongoDatabaseOperations;
import com.cyslab.craftvm.mongo.helper.MongoConfigHelper;
import com.mongodb.DB;
import com.mongodb.Mongo;

public class MongoDatabaseOperationsImpl implements MongoDatabaseOperations {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.startupoxygen.craft.mongo.MongoDatabaseOperations#createDataBase(
	 * java.lang.String)
	 * 
	 * To make a connection to a MongoDB, you need to have at the minimum, the
	 * name of a database to connect to. The database doesn't have to exist - if
	 * it doesn't, MongoDB will create it for you.
	 */
	@Override
	public DB createDataBase(String argDatabaseName) {
		Mongo mongo = MongoConfigHelper.getInstance().getMongo();
		return mongo.getDB(argDatabaseName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.startupoxygen.craft.mongo.MongoDatabaseOperations#dropDatabase(java
	 * .lang.String)
	 * 
	 * It deletes the entire database.
	 */
	@Override
	public void dropDatabase(String argDatabaseName) {
		Mongo mongo = MongoConfigHelper.getInstance().getMongo();
		mongo.dropDatabase(argDatabaseName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.startupoxygen.craft.mongo.MongoDatabaseOperations#getDatabaseNames()
	 * 
	 * Each database has zero or more collections. You can retrieve a list of
	 * them from the db (and print out any that are there)
	 */
	@Override
	public List<String> getDatabaseNames() {
		Mongo mongo = MongoConfigHelper.getInstance().getMongo();
		return mongo.getDatabaseNames();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.startupoxygen.craft.mongo.MongoDatabaseOperations#getDB(java.lang
	 * .String)
	 * 
	 * It fetches the MongoDB instance, you need to have at the minimum, the
	 * name of a database.
	 */
	@Override
	public DB getDB(String argDatabaseName) {
		return MongoConfigHelper.getInstance().getDb(argDatabaseName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.startupoxygen.craft.mongo.MongoDatabaseOperations#getUsedDatabases()
	 * 
	 * It fetches all the used databases.
	 */
	@Override
	public Collection<DB> getUsedDatabases() {
		Mongo mongo = MongoConfigHelper.getInstance().getMongo();
		return mongo.getUsedDatabases();
	}

}
