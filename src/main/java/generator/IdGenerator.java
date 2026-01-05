package generator;

import java.security.SecureRandom;

import repository.IdRepository;

public class IdGenerator {

	private static final SecureRandom RANDOM = new SecureRandom();
	private final IdRepository repository = new IdRepository();

	public IdGenerator() {
	}

	public synchronized String generateTaskId() {

		String id;

		do {
			id = String.valueOf(RANDOM.nextInt(90_000) + 10_000);
		} while (repository.exists(id));

		repository.save(id);
		return id;
	}
}
