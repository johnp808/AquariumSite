package com.skilldistillery.jpaaquariumsite.entities;

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

public class UserTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("AquariumSite");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}
	
	@Test
	void test_user_name() {
		assertNotNull(user);
		assertEquals("Uzidontbrick", user.getUserName());
	}
	
	@Test
	void test_user_age() {
		assertNotNull(user);
		assertEquals(30, user.getAge());
	}
	
	@Test
	void test_user_location() {
		user = em.find(User.class, 2);
		assertNotNull(user);
		assertEquals("Tokyo", user.getLocation());
	}
	
}
