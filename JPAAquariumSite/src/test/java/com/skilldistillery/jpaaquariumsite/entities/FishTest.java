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

public class FishTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Fish fish;
	
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
		fish = em.find(Fish.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		fish = null;
	}
	
	@Test
	void test_fish_fish_name() {
		assertNotNull(fish);
		assertEquals("Neon Tetra", fish.getFishName());
	}
	@Test
	void test_fish_many_to_one_mapping_aquarium_quantity() {
		fish = em.find(Fish.class, 1);
		assertNotNull(fish);
		assertEquals(10, fish.getFishInAquarium().get(0).getQuantity());
	}
	
	@Test
	void test_fish_many_to_one_mapping_aquarium_quantity_2() {
		fish = em.find(Fish.class, 3);
		assertNotNull(fish);
		assertEquals(2, fish.getFishInAquarium().get(0).getQuantity());
	}
	
	@Test
	void test_fish_fish_type() {
		assertNotNull(fish);
		assertEquals("Freshwater", fish.getFishType());
		assertEquals(10, fish.getFishInAquarium().get(0).getQuantity());
	}
	
	
	
}
