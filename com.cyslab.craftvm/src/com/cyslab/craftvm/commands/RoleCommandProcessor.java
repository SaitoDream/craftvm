package com.cyslab.craftvm.commands;

import com.cyslab.craftvm.metadata.security.Role;

public class RoleCommandProcessor extends AbstractCommandProcessor {
	private static final String ROLE = "role";

	public RoleCommandProcessor() {
		super();
	}

	@Override
	public void execute(CommandContext argCommandContext) {
		Command command = getCommand(argCommandContext);
		Role role = new Role();
		role.setName(command.getOptionValueByName("name"));
		argCommandContext.addRole(role);
	}
}
