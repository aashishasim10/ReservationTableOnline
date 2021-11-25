package group9.group9;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Group9ApplicationTests {

	@Test
	void contextLoads() {

		TableModel table=new TableModel();
		List<TableEntity> list=table.giveAllTable();
		System.out.println(list);
	}

}
