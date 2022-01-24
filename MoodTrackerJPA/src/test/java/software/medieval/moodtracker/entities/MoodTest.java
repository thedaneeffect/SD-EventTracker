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
		factory = null;
	}

	@BeforeEach
	void setUp() throws Exception {
		manager = factory.createEntityManager();
		mood = manager.find(Mood.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		manager.close();
		manager = null;
	}
}
