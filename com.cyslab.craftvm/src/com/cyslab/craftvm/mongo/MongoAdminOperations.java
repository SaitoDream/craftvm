package com.cyslab.craftvm.mongo;

import com.mongodb.CommandResult;
import com.mongodb.WriteResult;

public interface MongoAdminOperations {

	public WriteResult addUser(String argDatabaseName, String argUserName,
			String argPassword);

	public WriteResult addUser(String argDatabaseName, String argUserName,
			String argPassword, boolean argReadOnly);

	public boolean authenticate(String argDatabaseName, String argUserName,
			String argPassword);

	public CommandResult authenticateCommand(String argDatabaseName,
			String argUserName, String argPassword);

	public WriteResult removeUser(String argDatabaseName, String argUserName);
}
