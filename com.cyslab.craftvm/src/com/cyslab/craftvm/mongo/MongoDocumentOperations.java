package com.cyslab.craftvm.mongo;

import java.util.List;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public interface MongoDocumentOperations {

	public WriteResult addDocumentToCollection(String argDatabaseName,
			String argCollectionName, DBObject argDbObject);

	public WriteResult addDocumentsToCollection(String argDatabaseName,
			String argCollectionName, List<DBObject> argDbObjectsList);

	public long getDocumentsSize(String argCollectionName);

	public List<DBObject> fetchAllDocuments(String argDatabaseName,
			String argCollectionName);

	public DBObject fetchDocument(String argDatabaseName,
			String argCollectionName, DBObject argDbObjectQuery);

	public void removeDocument(String argDatabaseName,
			String argCollectionName, DBObject argDbObjectQuery);

	public DBCollection renameCollection(String argDatabaseName,
			String argOldCollectionName, String argNewCollectionName);

	public DBObject fetchFirstDocument(String argDatabaseName,
			String argCollectionName);
}
