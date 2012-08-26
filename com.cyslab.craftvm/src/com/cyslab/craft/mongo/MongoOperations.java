package com.cyslab.craft.mongo;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.mongodb.CommandResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;

public interface MongoOperations {

	public DB createDataBase(String argDatabaseName);

	public WriteResult addUser(String argUserName, String argPassword);

	public WriteResult addUser(String argUserName, String argPassword,
			boolean argReadOnly);

	public boolean authenticate(String argUserName, String argPassword);

	public CommandResult authenticateCommand(String argUserName,
			String argPassword);

	public void dropDatabase(String argDatabaseName);

	public List<String> getDatabaseNames();

	public DB getDB(String argDatabaseName);

	public Collection<DB> getUsedDatabases();

	public DBCollection createCollection(String argCollectionName,
			DBObject argDbObject);

	public boolean isCollectionExists(String argCollectionName);

	public DBCollection getCollection(String argCollectionName);

	public DBCollection getCollectionFromString(String argCollectionName);

	public Set<String> getCollectionNames();

	public String getDatabaseName();

	public Mongo getMongoInstance();

	public CommandResult getDatabaseStats();

	public DB getSecondDatabase(String argDatabaseName);

	public boolean isAuthenticated();

	public WriteResult removeUser(String argUserName);

	public WriteResult addDocumentToCollection(String argCollectionName,
			DBObject argDbObject);

	public WriteResult addDocumentsToCollection(String argCollectionName,
			List<DBObject> argDbObjectsList);

	public long getDocumentsSize(String argCollectionName);

	public void deleteCollection(String argCollectionName);

	public List<DBObject> fetchAllDocuments(String argCollectionName);

	public DBObject fetchDocument(String argCollectionName,
			DBObject argDbObjectQuery);

	public void removeDocument(String argCollectionName,
			DBObject argDbObjectQuery);

	public DBCollection renameCollection(String argOldCollectionName,
			String argNewCollectionName);

	public DBObject fetchFirstDocument(String argCollectionName);
}
