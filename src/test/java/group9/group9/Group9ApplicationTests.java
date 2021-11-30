package group9.group9;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Group9ApplicationTests {
 @Autowired
 TableController tableController;
	@Test
	void contextLoads() {

		//tableController.combineTable();
	}

}
