package com.cyslab.craftvm;

import com.cyslab.craftvm.metadata.Field;

public class FieldAndValue {
	private Field field;
	private String value;

	public Field getField() {
		return this.field;
	}

	public void setField(Field argField) {
		this.field = argField;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String argValue) {
		this.value = argValue;
	}

}
