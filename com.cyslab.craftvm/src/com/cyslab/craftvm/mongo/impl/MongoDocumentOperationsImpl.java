package com.cyslab.craftvm.mongo.impl;

import java.util.List;

import com.cyslab.craftvm.mongo.MongoDocumentOperations;
import com.cyslab.craftvm.mongo.helper.MongoConfigHelper;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.WriteConcern;
import com.mongodb.WriteResult;

public class MongoDocumentOperationsImpl implements MongoDocumentOperations {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.startupoxygen.craft.mongo.MongoDocumentOperations#addDocumentToCollection
	 * (java.lang.String, java.lang.String, com.mongodb.DBObject)
	 * 
	 * Exceptions are raised for network issues, and server errors and the write
	 * operation waits for the server to flush the data to disk
	 * http://api.mongodb.org/java/2.5/com/mongodb/WriteConcern.html
	 */
	@Override
	public WriteResult addDocumentToCollection(String argDatabaseName,
			String argCollectionName, DBObject argDbObject) {
		DBCollection dbCollection = MongoConfigHelper.getInstance()
				.getCollection(argDatabaseName, argCollectionName);
		return dbCollection.insert(argDbObject, WriteConcern.FSYNC_SAFE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.startupoxygen.craft.mongo.MongoDocumentOperations#
	 * addDocumentsToCollection(java.lang.String, java.lang.String,
	 * java.util.List)
	 * 
	 * Exceptions are raised for network issues, and server errors and the write
	 * operation waits for the server to flush the data to disk
	 */
	@Override
	public WriteResult addDocumentsToCollection(String argDatabaseName,
			String argCollectionName, List<DBObject> argDbObjectsList) {
		DBCollection dbCollection = MongoConfigHelper.getInstance()
				.getCollection(argDatabaseName, argCollectionName);
		return dbCollection.insert(argDbObjectsList, WriteConcern.FSYNC_SAFE);
	}

	@Override
	public long getDocumentsSize(String argCollectionName) {
		return 0;
	}

	@Override
	public List<DBObject> fetchAllDocuments(String argDatabaseName,
			String argCollectionName) {
		DBCollection dbCollection = MongoConfigHelper.getInstance()
				.getCollection(argDatabaseName, argCollectionName);
		DBCursor dbCursor = dbCollection.find();
		return dbCursor.toArray();
	}

	@Override
	public DBObject fetchDocument(String argDatabaseName,
			String argCollectionName, DBObject argDbObjectQuery) {
		DBCollection dbCollection = MongoConfigHelper.getInstance()
				.getCollection(argDatabaseName, argCollectionName);
		return dbCollection.findOne(argDbObjectQuery);
	}

	@Override
	public void removeDocument(String argDatabaseName,
			String argCollectionName, DBObject argDbObjectQuery) {
		DBCollection dbCollection = MongoConfigHelper.getInstance()
				.getCollection(argDatabaseName, argCollectionName);
		dbCollection.remove(argDbObjectQuery);
	}

	@Override
	public DBCollection renameCollection(String argDatabaseName,
			String argOldCollectionName, String argNewCollectionName) {
		DBCollection dbCollection = MongoConfigHelper.getInstance()
				.getCollection(argDatabaseName, argOldCollectionName);
		return dbCollection.rename(argNewCollectionName);
	}

	@Override
	public DBObject fetchFirstDocument(String argDatabaseName,
			String argCollectionName) {
		DBCollection dbCollection = MongoConfigHelper.getInstance()
				.getCollection(argDatabaseName, argCollectionName);
		return dbCollection.findOne();
	}

}
