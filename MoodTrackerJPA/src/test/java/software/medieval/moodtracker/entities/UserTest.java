package software.medieval.moodtracker.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

	private static EntityManagerFactory factory;
	private EntityManager manager;
	private User user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		factory = Persistence.createEntityManagerFactory("MoodTrackerJPA");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		factory.close();
		factory = null;
	}

	@BeforeEach
	void setUp() throws Exception {
		manager = factory.createEntityManager();
		user = manager.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		manager.close();
		manager = null;
	}

	@Test
	void name_mapping() throws Exception {
		assertNotNull(user);
		assertEquals("dane", user.getName());
	}

	@Test
	void password_mapping() throws Exception {
		assertNotNull(user);
		assertEquals("$2a$10$g5ecCfZBSXhlI8zI/PC.LeeHmYRS4MhX70f063yiS9aWfbm/UGtg2", user.getPassword());
	}

	@Test
	void role_mapping() throws Exception {
		assertNotNull(user);
		assertEquals("standard", user.getRole());
	}

	@Test
	void created_on_mapping() throws Exception {
		assertNotNull(user);
		assertNotNull(user.getCreatedOn());
	}

	@Test
	void updated_on_mapping() throws Exception {
		assertNotNull(user);
		assertNotNull(user.getUpdatdOn());
	}
}
