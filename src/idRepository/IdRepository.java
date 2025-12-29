package idRepository;

import java.util.HashSet;
import java.util.Set;

public class IdRepository {

	private final Set<String> ids = new HashSet<>();

	public synchronized boolean exists(String id) {
		return ids.contains(id);
	}

	public synchronized void save(String id) {
		ids.add(id);
	}

}
