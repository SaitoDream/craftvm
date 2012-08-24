package com.cyslab.craftvm.commands;

import com.cyslab.craftvm.metadata.Entity;
import com.cyslab.craftvm.metadata.security.Filter;
import com.cyslab.craftvm.metadata.security.Grant;

public class GrantCommandProcessor extends AbstractCommandProcessor {
	private static final String GRANT = "grant";
	private static final String ALL = "*";

	public GrantCommandProcessor() {
		super();
	}

	@Override
	public void execute(CommandContext argCommandContext) {
		Command command = getCommand(argCommandContext);
		Grant grant = new Grant();
		grant.setPermissions(command.getOptionValueListByName("permission"));
		String entityName = command.getOptionValueByName("entity");
		Entity entity = null;
		if (entityName != null && ALL.equals(entity)) {
			entity = argCommandContext.getEntityByName(entityName);
		}
		grant.setEntity(entity);
		grant.setFilters(Filter.newFilterList(command
				.getOptionValueListByName("filterby")));
		argCommandContext.addGrant(grant);
	}
}
