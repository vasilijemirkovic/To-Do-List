package generator;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class TestIdGenerator {

	IdGenerator idGenerator = new IdGenerator();

	@Test
	public void generateTaskPositiveNotNullTest() {

		String id = idGenerator.generateTaskId();
		assert (id != null);
	}

	@Test
	public void generateTaskPositiveLengthTest() {

		String id = idGenerator.generateTaskId();
		assert (id.length() == 5);
	}

	@Test
	public void generateTaskPositiveScopeTest() {

		String id = idGenerator.generateTaskId();
		assert (Integer.parseInt(id) >= 10000 && Integer.parseInt(id) <= 99999);
	}

	@Test
	public void generateTaskNotValidId() {

		String id = idGenerator.generateTaskId();

		assertFalse(Integer.parseInt(id) < 10000 || Integer.parseInt(id) > 99999);
	}

}
