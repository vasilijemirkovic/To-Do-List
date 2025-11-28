package idGenerator;

import java.util.Random;
//TODO: zavrsiti generator
public class IdGenerator {
	
	Random random = new Random();
	
	
	public int generateIdForTask() {
		int id = 0;

		for(int i = 0; i < 3; i++) {
			
			int num = random.nextInt(9);
			id*=10;
			id+=num;
		}
		return id;
	}

}
