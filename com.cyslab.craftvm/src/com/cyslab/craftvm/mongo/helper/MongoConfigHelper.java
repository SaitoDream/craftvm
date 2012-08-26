package com.cyslab.craftvm.mongo.helper;

import java.util.Properties;

import com.cyslab.craftvm.mongo.util.MongoUtil;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

public class MongoConfigHelper {

	private static MongoConfigHelper instance = createInstance();

	private MongoUtil mongoUtil;

	/*
	 * propertiesFilePath for Mongo initialization.
	 */
	private static final String propertiesFilePath = "./conf/mongodb.conf";

	private static MongoConfigHelper createInstance() {
		MongoConfigHelper mongoConfigHelper = new MongoConfigHelper();
		mongoConfigHelper.initialize();
		return mongoConfigHelper;
	}

	private synchronized void initialize() {
		this.setMongoUtil(MongoUtil.createInstance(propertiesFilePath));
	}

	public static MongoConfigHelper getInstance() {
		return instance;
	}

	public Properties getProperties() {
		return this.mongoUtil.getProperties();
	}

	public MongoUtil getMongoUtil() {
		return this.mongoUtil;
	}

	public void setMongoUtil(MongoUtil argMongoUtil) {
		this.mongoUtil = argMongoUtil;
	}

	public Mongo getMongo() {
		return this.mongoUtil.getMongo();
	}

	public void close() {
		this.mongoUtil.close();
	}

	public DB getDb(String argDatabaseName) {
		Mongo mongo = getMongo();
		return mongo.getDB(argDatabaseName);
	}

	public DBCollection getCollection(String argDatabaseName,
			String argCollectionName) {
		DB db = getDb(argDatabaseName);
		return db.getCollection(argCollectionName);
	}

}
