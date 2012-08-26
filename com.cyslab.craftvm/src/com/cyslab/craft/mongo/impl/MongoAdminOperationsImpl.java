package com.cyslab.craft.mongo.impl;

import com.cyslab.craft.mongo.MongoAdminOperations;
import com.cyslab.craft.mongo.helper.MongoConfigHelper;
import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;

public class MongoAdminOperationsImpl implements MongoAdminOperations {

	@Override
	public WriteResult addUser(String argDatabaseName, String argUserName,
			String argPassword) {
		Mongo mongo = MongoConfigHelper.getInstance().getMongo();
		DB db = mongo.getDB(argDatabaseName);
		return db.addUser(argUserName, argPassword.toCharArray());
	}

	@Override
	public WriteResult addUser(String argDatabaseName, String argUserName,
			String argPassword, boolean argReadOnly) {
		Mongo mongo = MongoConfigHelper.getInstance().getMongo();
		DB db = mongo.getDB(argDatabaseName);
		return db.addUser(argUserName, argPassword.toCharArray(), argReadOnly);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.startupoxygen.craft.mongo.MongoAdminOperations#authenticate(java.
	 * lang.String, java.lang.String, java.lang.String)
	 * 
	 * MongoDB can be run in a secure mode where access to databases is
	 * controlled through name and password authentication. When run in this
	 * mode, any client application must provide a name and password before
	 * doing any operations.
	 */
	@Override
	public boolean authenticate(String argDatabaseName, String argUserName,
			String argPassword) {
		Mongo mongo = MongoConfigHelper.getInstance().getMongo();
		DB db = mongo.getDB(argDatabaseName);
		return db.authenticate(argUserName, argPassword.toCharArray());
	}

	@Override
	public CommandResult authenticateCommand(String argDatabaseName,
			String argUserName, String argPassword) {
		Mongo mongo = MongoConfigHelper.getInstance().getMongo();
		DB db = mongo.getDB(argDatabaseName);
		return db.authenticateCommand(argUserName, argPassword.toCharArray());
	}

	@Override
	public WriteResult removeUser(String argDatabaseName, String argUserName) {
		Mongo mongo = MongoConfigHelper.getInstance().getMongo();
		DB db = mongo.getDB(argDatabaseName);
		return db.removeUser(argUserName);
	}

}
