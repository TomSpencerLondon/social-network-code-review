package it.voxsim.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.voxsim.exception.UserNotExistsException;

public class InMemoryLinkRepository implements LinkRepository {

	private Map<String, Set<String>> linksByUsername = new HashMap<>();

	private static Set<String> apply(String k) {
		return new HashSet<>();
	}

	public List<String> retrieveLinksByUsername(String username) {
		Set<String> links = linksByUsername.get(username);
		ArrayList<String> result = new ArrayList<>();

		if (links != null)
			result.addAll(links);

		return result;
	}

	public void saveIfNotExist(String username) {
		linksByUsername.computeIfAbsent(username, InMemoryLinkRepository::apply);
	}

	public void addLinkBetween(String username, String argument) {
		Set<String> links = linksByUsername.get(username);

        if(links == null)
            throw new UserNotExistsException();

		links.add(argument);
	}
}
