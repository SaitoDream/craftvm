package com.cyslab.craftvm.mongo.data.generator;

import java.util.GregorianCalendar;

public class RandomDateGenerator {

	public static String generateRandomDates() {

		int year = RandomDateGenerator.randBetween(1900, 2010);

		int month = RandomDateGenerator.randBetween(0, 11);

		GregorianCalendar gc = new GregorianCalendar(year, month, 1);

		int day = RandomDateGenerator.randBetween(1,
				gc.getActualMaximum(GregorianCalendar.DAY_OF_MONTH));

		gc.set(year, month, day);

		String date = gc.get(GregorianCalendar.YEAR) + "-"
				+ gc.get(GregorianCalendar.MONTH) + "-"
				+ gc.get(GregorianCalendar.DAY_OF_MONTH);
		// System.out.println(date);
		return date;
	}

	private static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}
}
