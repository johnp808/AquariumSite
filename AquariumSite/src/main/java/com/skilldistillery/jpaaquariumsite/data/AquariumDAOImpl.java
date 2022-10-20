package com.skilldistillery.jpaaquariumsite.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpaaquariumsite.entities.Aquarium;

@Service
@Transactional
public class AquariumDAOImpl implements AquariumDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Aquarium> findAll() {
		String jpql = "SELECT aquarium FROM Aquarium aquarium";
		List<Aquarium> aquarium = em.createQuery(jpql, Aquarium.class).getResultList();
		return aquarium;
	}

	@Override
	public Aquarium findById(int aquariumId) {
		return em.find(Aquarium.class, aquariumId);
	}

	@Override
	public Aquarium createAquarium(Aquarium aquarium) {
		em.persist(aquarium);
		return aquarium;
	}

	@Override
	public Aquarium updateAquarium(int aquariumId, Aquarium aquarium) {
		Aquarium dbAquarium = em.find(Aquarium.class, aquariumId);
		dbAquarium.setTankSizeInGallons(aquarium.getTankSizeInGallons());
		dbAquarium.setTypeOfAquarium(aquarium.getTypeOfAquarium());
		dbAquarium.setTotalAmountOfFish(aquarium.getTotalAmountOfFish());
		dbAquarium.setTotalAmountOfPlants(aquarium.getTotalAmountOfPlants());
		dbAquarium.setAquariumStartDate(aquarium.getAquariumStartDate());
		dbAquarium.setFishInAquarium(aquarium.getFishInAquarium());
		return dbAquarium;
	}

	@Override
	public boolean deleteAquarium(int aquariumId) {
		boolean success = false;
		Aquarium aquarium = em.find(Aquarium.class, aquariumId);
		if(aquarium != null) {
			em.remove(aquarium);
			success = !em.contains(aquarium);
		}
		return success;
	}

}
