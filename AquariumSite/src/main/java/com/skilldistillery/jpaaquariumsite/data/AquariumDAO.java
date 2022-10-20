package com.skilldistillery.jpaaquariumsite.data;

import java.util.List;

import com.skilldistillery.jpaaquariumsite.entities.Aquarium;

public interface AquariumDAO {

	List<Aquarium> findAll();

	Aquarium findById(int userId);

	Aquarium createAquarium(Aquarium aquarium);

	Aquarium updateAquarium(int userId, Aquarium aquarium);

	boolean deleteAquarium(int userId);
		
}
