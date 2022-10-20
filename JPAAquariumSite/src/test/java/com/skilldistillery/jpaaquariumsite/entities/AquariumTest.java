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

public class AquariumTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Aquarium aquarium;
	
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
		aquarium = em.find(Aquarium.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		aquarium = null;
	}
	
	@Test
	void test_aquarium_tank_size() {
		assertNotNull(aquarium);
		assertEquals(15, aquarium.getTankSizeInGallons());
		assertEquals(10, aquarium.getTotalAmountOfFish());
	}
	
//	@Test
//	void test_aquarium_user_id_mapping() {
//		assertNotNull(aquarium);
//		assertEquals("Uzidontbrick", aquarium.getFishInAquarium().get(0).getAquarium().getUserId().getUserName());
//	}
	
	@Test
	void test_aquarium_many_to_one_mapping_to_fish_size() {
		aquarium = em.find(Aquarium.class, 2);
		assertNotNull(aquarium);
		assertEquals(1.25, aquarium.getFishInAquarium().get(0).getFish().getFishMaxSize());
	}
	
	@Test
	void test_aquarium_many_to_one_mapping_to_fish_quantity() {
		aquarium = em.find(Aquarium.class, 4);
		assertNotNull(aquarium);
		assertEquals(35, aquarium.getFishInAquarium().get(0).getQuantity());
	}
	
//	@Test
//	void test_aquarium_user_2_id_and_amount_of_fish() {
//		aquarium = em.find(Aquarium.class, 5);
//		assertNotNull(aquarium);
//		assertEquals(55, aquarium.getTotalAmountOfFish());
//		assertEquals("AimiNakas", aquarium.getUserId().getUserName());
//	}
//	
}
