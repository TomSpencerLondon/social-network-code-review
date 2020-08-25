package it.voxsim.command;

import java.util.HashMap;
import java.util.Map;

import it.voxsim.repository.LinkRepository;
import it.voxsim.repository.MessageRepository;

public class CommandDispatcher {
	private Map<String, Command> commands;

	public CommandDispatcher(MessageRepository messageRepository, LinkRepository linkRepository) {
		commands = new HashMap<>();
		commands.put(null, ReadCommand.create(messageRepository));
		commands.put("->", new PostCommand(messageRepository, linkRepository));
		commands.put("follows", new FollowCommand(linkRepository));
		commands.put("wall", WallCommand.create(messageRepository, linkRepository));
	}

	public Command dispatch(String action) {
		return commands.get(action);
	}
}