package com.cyslab.craftvm.commands;


public class TableCommandProcessor extends AbstractCommandProcessor {
	private static final String ENTITY = "entity";

	public TableCommandProcessor() {
		super();
	}

	@Override
	public void execute(CommandContext argCommandContext) {
		Command command = getCommand(argCommandContext);
	}
}
