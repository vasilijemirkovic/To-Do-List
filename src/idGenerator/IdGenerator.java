package idGenerator;

import java.security.SecureRandom;

import idRepository.IdRepository;

public class IdGenerator {

	private static final SecureRandom RANDOM = new SecureRandom();
	private final IdRepository repository;

	public IdGenerator(IdRepository repository) {
		this.repository = repository;
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
