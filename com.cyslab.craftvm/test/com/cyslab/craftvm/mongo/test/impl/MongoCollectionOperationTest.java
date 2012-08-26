package com.cyslab.craftvm.mongo.test.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.collections.MultiMap;
import org.junit.Before;
import org.junit.Test;

import com.cyslab.craftvm.Craft;
import com.cyslab.craftvm.CraftProjectCache;
import com.cyslab.craftvm.metadata.Entity;
import com.cyslab.craftvm.metadata.Field;
import com.cyslab.craftvm.metadata.Project;
import com.cyslab.craftvm.mongo.MongoCollectionOperations;
import com.cyslab.craftvm.mongo.MongoDatabaseOperations;
import com.cyslab.craftvm.mongo.MongoDocumentOperations;
import com.cyslab.craftvm.mongo.data.generator.SampleDataGenerator;
import com.cyslab.craftvm.mongo.helper.MongoConfigHelper;
import com.cyslab.craftvm.mongo.impl.MongoCollectionOperationsImpl;
import com.cyslab.craftvm.mongo.impl.MongoDatabaseOperationsImpl;
import com.cyslab.craftvm.mongo.impl.MongoDocumentOperationsImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;

public class MongoCollectionOperationTest {

	private static final int NO_OF_RECORDS = 4;

	private Project project;

	private Craft craft;

	private String projectContextPath = "rise";

	private String[] databaseNames = { "rise", "drs", "simrise" };

	private MongoDatabaseOperations mongoDatabaseOperations = new MongoDatabaseOperationsImpl();

	private MongoCollectionOperations mongoCollectionOperations = new MongoCollectionOperationsImpl();

	private MongoDocumentOperations mongoDocumentOperations = new MongoDocumentOperationsImpl();

	private MultiMap multiValueMap = SampleDataGenerator.createWithTestData();

	private List<String> acceptedDatatypes;

	private List<String> dataTypesList;

	private String[] columnNames = { "title", "firstName", "middleName",
			"lastName", "suffix", "city", "state", "country", "emailAddress",
			"phoneNumber", "postalCode", "streetAddress", "date", "url", "imId" };
	private String[] dataTypes = { "string", "date", "boolean" };

	@Before
	public void setup() {
		MongoConfigHelper.getInstance();
		CraftProjectCache.getInstance();
		this.craft = new Craft();
		// this.project = this.craft
		// .getProjectByContextPath(this.projectContextPath);
		this.acceptedDatatypes = Arrays.asList(this.columnNames);
		this.dataTypesList = Arrays.asList(this.dataTypes);
	}

	@Test
	public void testInsertDataIntoCollections() throws Exception {
		for (int i = 0; i < databaseNames.length; i++) {
			this.project = this.craft.getProjectByContextPath(databaseNames[i]);
			String databaseName = this.project.getDb();
			System.out.println("######################## Database Name: "
					+ databaseName + "##################################");
			createDatabase(databaseName);
			Collection<Entity> entities = this.project.getEntities();
			if (entities != null && entities.size() > 0) {
				Iterator<Entity> iter = entities.iterator();
				System.out
						.println("################# Collection Insertion Started ########################");
				while (iter.hasNext()) {
					Entity entity = iter.next();
					createCollection(entity.getName());
					List<DBObject> dbObjectsList = addDocumentsToCollection(
							databaseName, entity);
					this.mongoDocumentOperations.addDocumentsToCollection(
							databaseName, entity.getName(), dbObjectsList);
				}
				System.out
						.println("################# Collection Insertion Emded ########################");
			}
		}
	}

	@SuppressWarnings("unchecked")
	private List<DBObject> addDocumentsToCollection(String argDatabaseName,
			Entity argEntity) {
		Collection<Field> fields = argEntity.getFields();
		List<DBObject> basicDBList = new ArrayList<DBObject>();
		Random r = new Random(100);
		for (int i = 0; i < NO_OF_RECORDS; i++) {
			BasicDBObject basicDBObject = new BasicDBObject();
			Iterator<Field> fieldsIterator = fields.iterator();
			while (fieldsIterator.hasNext()) {
				Field field = fieldsIterator.next();
				List<String> valueList = null;
				if (this.acceptedDatatypes.contains(field.getName())) {
					valueList = (List<String>) this.multiValueMap.get(field
							.getName());
				} else if (this.dataTypesList.contains(field.getDataType()
						.getName())) {
					valueList = (List<String>) this.multiValueMap.get(field
							.getDataType().getName());
				}
				if (valueList != null && valueList.size() > 0) {
					String value = valueList.get(r.nextInt(valueList.size()));
					basicDBObject.put(field.getName(), value);
				}
			}
			basicDBList.add(basicDBObject);
		}
		return basicDBList;
	}

	private void createCollection(String argName) {
		if (argName != null && !argName.isEmpty()) {
			DBCollection dbCollection = this.mongoCollectionOperations
					.createCollection(this.projectContextPath, argName, null);
			System.out.println(this.project.getDb() + "."
					+ dbCollection.getName());
		}
	}

	private void createDatabase(String databaseName) {
		DB db = this.mongoDatabaseOperations.createDataBase(databaseName);
		if (db != null) {
			System.out.println("Database Name: " + db.getName());
		}
	}

	@Test
	public void testDisplayRecords() {
		for (int j = 0; j < databaseNames.length; j++) {
			this.project = this.craft.getProjectByContextPath(databaseNames[j]);
			System.out.println("##################################### Database Name: "
					+ this.project.getDb()
					+ "#################################################");
			Collection<Entity> entities = this.project.getEntities();
			if (entities != null && entities.size() > 0) {
				Iterator<Entity> entityIterator = entities.iterator();
				System.out
						.println("################################# Starting: Fetching All Records ####################################");
				int i = 1;
				while (entityIterator.hasNext()) {
					Entity entity = entityIterator.next();
					System.out
							.println("*************************** Starting: Entity/Collection Name "
									+ entity.getName()
									+ i
									+ " **************************************");
					List<DBObject> dbObjects = this.mongoDocumentOperations
							.fetchAllDocuments(this.project.getDb(),
									entity.getName());
					if (dbObjects != null && dbObjects.size() > 0) {
						for (DBObject dbObject : dbObjects) {
							System.out.println(dbObject.toString());
						}
					}
					System.out
							.println("*************************** Ending: Entity/Collection Name "
									+ i
									+ " **************************************");
					++i;
				}
				System.out
						.println("################################# Ending: Fetching All Records ####################################");
			}
		}
	}
}
