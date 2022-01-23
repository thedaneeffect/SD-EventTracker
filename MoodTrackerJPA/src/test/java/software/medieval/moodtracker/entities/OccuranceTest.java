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

class OccuranceTest {

	private static EntityManagerFactory factory;
	private EntityManager manager;
	private Occurance occurance;

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
		occurance = manager.find(Occurance.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		manager.close();
		manager = null;
	}

	@Test
	void mood_mapping() throws Exception {
		assertNotNull(occurance);
		assertNotNull(occurance.getMood());
		assertEquals(1, occurance.getMood().getId());
	}

	@Test
	void created_at_mapping() throws Exception {
		assertNotNull(occurance);
		assertNotNull(occurance.getCreatedAt());
		assertEquals(2022, occurance.getCreatedAt().getYear());
		assertEquals(1, occurance.getCreatedAt().getMonthValue());
		assertEquals(45, occurance.getCreatedAt().getMinute());
		assertEquals(25, occurance.getCreatedAt().getSecond());
	}
	
	
	@Test
	void happened_at_mapping() throws Exception {
		assertNotNull(occurance);
		assertNotNull(occurance.getHappenedAt());
		assertEquals(2022, occurance.getHappenedAt().getYear());
		assertEquals(1, occurance.getHappenedAt().getMonthValue());
		assertEquals(45, occurance.getHappenedAt().getMinute());
		assertEquals(25, occurance.getHappenedAt().getSecond());
	}
	@Test
	void description_mapping() throws Exception {
		assertNotNull(occurance);
		assertNotNull(occurance.getDescription());
		assertEquals("I was just feeling good.", occurance.getDescription());
	}

}
