package com.cyslab.craftvm.commands;

import com.cyslab.craftvm.metadata.DataTypeFactory;
import com.cyslab.craftvm.metadata.Relationship;
import com.cyslab.craftvm.metadata.RelationshipType;

public class RelationshipCommandProcessor extends AbstractCommandProcessor {
	private static final String FIELD = "field";

	public RelationshipCommandProcessor() {
		super();
	}

	@Override
	public void execute(CommandContext argCommandContext) {
		Command command = getCommand(argCommandContext);
		Relationship relationship = new Relationship();
		relationship.setRelationshipType(RelationshipType.valueOf(command.getName()));
		relationship.setDataType(DataTypeFactory.fromName(command
				.getOptionValueByName("type")));
		relationship.setName(command.getOptionValueByName("name"));
		relationship.setRequired(command.isOptionPresent("required"));
		argCommandContext.addField(relationship);
	}
}
