package software.medieval.moodtracker.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoodTest {

	private static EntityManagerFactory factory;
	private EntityManager manager;
	private Mood mood;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		factory = Persistence.createEntityManagerFactory("MoodTrackerJPA");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		factory.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		manager = factory.createEntityManager();
		mood = manager.find(Mood.class, new MoodId("2022-01-01", 1));
		System.out.println(mood);
	}

	@AfterEach
	void tearDown() throws Exception {
		manager.close();
	}

	@Test
	void value_mapping() throws Exception {
		assertNotNull(mood);
		assertEquals(4, mood.getValue());
	}

	@Test
	void description_mapping() throws Exception {
		assertNotNull(mood);
		assertEquals("It's new years!", mood.getDescription());
	}
}
