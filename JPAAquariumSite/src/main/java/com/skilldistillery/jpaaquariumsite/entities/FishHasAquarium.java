package com.skilldistillery.jpaaquariumsite.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="fish_has_aquarium")
public class FishHasAquarium {

	@EmbeddedId
	FishHasAquariumKey id;
	
	@ManyToOne
	@MapsId("fishId")
	@JoinColumn(name = "fish_id")
	Fish fish;
	
	
	@ManyToOne
	@MapsId("aquariumId")
	@JoinColumn(name = "aquarium_id")
	Aquarium aquarium;
	
	private int quantity;
	
	public FishHasAquarium() {}

	public FishHasAquariumKey getId() {
		return id;
	}

	public void setId(FishHasAquariumKey id) {
		this.id = id;
	}

	public Fish getFish() {
		return fish;
	}

	public void setFish(Fish fish) {
		this.fish = fish;
	}

	public Aquarium getAquarium() {
		return aquarium;
	}

	public void setAquarium(Aquarium aquarium) {
		this.aquarium = aquarium;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
