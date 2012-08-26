package com.cyslab.craftvm.mongo.data.generator;

import java.util.Random;

import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap;

public class SampleDataGenerator {

	private static MultiMap keyValuePairMap = new MultiValueMap();;

	/**
	 * Natural property order for Person bean. Used in tables and forms.
	 */
	public static final Object[] NATURAL_COL_ORDER = new Object[] {
			"firstName", "lastName", "email", "phoneNumber", "streetAddress",
			"postalCode", "city" };

	/**
	 * "Human readable" captions for properties in same order as in
	 * NATURAL_COL_ORDER.
	 */
	public static final String[] COL_HEADERS_ENGLISH = new String[] {
			"First name", "Last name", "Email", "Phone number",
			"Street Address", "Postal Code", "City" };

	public SampleDataGenerator() {
		// Do Nothing...
	}

	public static MultiMap createWithTestData() {

		final String[] titles = { "Mrs.", "Mr.", "Ms.", "Baby.", "Master.",
				"Prof.", "Dr.", "Gen.", "Rep.", "Sen.", "St.", "Sr.", "Jr.",
				"Ph.D.", "M.D.", "B.A.", "M.A.", "D.D.S." };
		final String[] fnames = { "Peter", "Alice", "Joshua", "Mike", "Olivia",
				"Nina", "Alex", "Rita", "Dan", "Umberto", "Henrik", "Rene",
				"Lisa", "Marge" };
		final String[] lnames = { "Smith", "Gordon", "Simpson", "Brown",
				"Clavel", "Simons", "Verne", "Scott", "Allison", "Gates",
				"Rowling", "Barks", "Ross", "Schneider", "Tate" };
		final String[] cities = { "Amsterdam", "Berlin", "Helsinki",
				"Hong Kong", "London", "Luxemburg", "New York", "Oslo",
				"Paris", "Rome", "Stockholm", "Tokyo", "Turku" };
		final String[] states = { "Alabama", "Alaska", "Arizona", "Arkansas",
				"California", "Colorado", "Connecticut", "Delaware", "Florida",
				"Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
				"Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
				"Massachusetts", "Michigan", "Minnesota", "Mississippi",
				"Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire",
				"New Jersey", "New Mexico", "New York", "North Carolina",
				"North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania",
				"Rhode Island", "South Carolina", "South Dakota", "Tennessee",
				"Texas", "Utah", "Vermont", "Virginia", "Washington",
				"West Virginia", "Wisconsin", "Wyoming" };
		final String[] countries = { "USA" };
		final String[] streets = { "4215 Blandit Av.", "452-8121 Sem Ave",
				"279-4475 Tellus Road", "4062 Libero. Av.", "7081 Pede. Ave",
				"6800 Aliquet St.", "P.O. Box 298, 9401 Mauris St.",
				"161-7279 Augue Ave", "P.O. Box 496, 1390 Sagittis. Rd.",
				"448-8295 Mi Avenue", "6419 Non Av.",
				"659-2538 Elementum Street", "2205 Quis St.",
				"252-5213 Tincidunt St.", "P.O. Box 175, 4049 Adipiscing Rd.",
				"3217 Nam Ave", "P.O. Box 859, 7661 Auctor St.",
				"2873 Nonummy Av.", "7342 Mi, Avenue",
				"539-3914 Dignissim. Rd.", "539-3675 Magna Avenue",
				"Ap #357-5640 Pharetra Avenue", "416-2983 Posuere Rd.",
				"141-1287 Adipiscing Avenue", "Ap #781-3145 Gravida St.",
				"6897 Suscipit Rd.", "8336 Purus Avenue", "2603 Bibendum. Av.",
				"2870 Vestibulum St.", "Ap #722 Aenean Avenue",
				"446-968 Augue Ave", "1141 Ultricies Street",
				"Ap #992-5769 Nunc Street", "6690 Porttitor Avenue",
				"Ap #105-1700 Risus Street",
				"P.O. Box 532, 3225 Lacus. Avenue", "736 Metus Street",
				"414-1417 Fringilla Street", "Ap #183-928 Scelerisque Road",
				"561-9262 Iaculis Avenue" };
		final boolean[] booleanValues = { true, false };
		Random r = new Random(0);
		for (int i = 0; i < 100; i++) {
			String firstName = fnames[r.nextInt(fnames.length)];
			String lastName = lnames[r.nextInt(lnames.length)];
			keyValuePairMap.put("title", titles[r.nextInt(titles.length)]);
			keyValuePairMap.put("firstName", firstName);
			keyValuePairMap.put("middleName", lastName);
			keyValuePairMap.put("lastName", lastName);
			keyValuePairMap.put("suffix", titles[r.nextInt(titles.length)]);
			keyValuePairMap.put("city", cities[r.nextInt(cities.length)]);
			keyValuePairMap.put("state", states[r.nextInt(cities.length)]);
			keyValuePairMap.put("country", countries[0]);
			keyValuePairMap.put("emailAddress", firstName.toLowerCase() + "."
					+ lastName.toLowerCase() + "@gmail.com");
			keyValuePairMap.put("phoneNumber",
					"+91994925" + r.nextInt(10) + r.nextInt(10) + r.nextInt(10)
							+ r.nextInt(10));
			int n = r.nextInt(100000);
			if (n < 10000) {
				n += 10000;
			}
			keyValuePairMap.put("postalCode", String.valueOf(n));
			keyValuePairMap.put("streetAddress",
					streets[r.nextInt(streets.length)]);
			keyValuePairMap.put("age", r.nextInt(10) + r.nextInt(10));
			keyValuePairMap.put("dateOfBirth",
					RandomDateGenerator.generateRandomDates());
			keyValuePairMap.put("url", "www." + firstName + lastName + ".com");
			keyValuePairMap.put("imId", firstName + "." + lastName
					+ "@sample.com");
			keyValuePairMap.put("string", firstName + lastName);
			keyValuePairMap.put("date",
					RandomDateGenerator.generateRandomDates());
			keyValuePairMap.put("int", r.nextInt(10) + r.nextInt(10));
			boolean result = booleanValues[r.nextInt(booleanValues.length)];
			keyValuePairMap.put("boolean", String.valueOf(result));
		}
		return keyValuePairMap;
	}

}
