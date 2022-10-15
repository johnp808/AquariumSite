package com.skilldistillery.jpaaquariumsite.entities;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Aquarium {

	@Id
	private int id;
	
	@ManyToOne
    @JoinColumn(name="user_id")
	private User userId;
	
	@Column(name="tank_size_in_gallons")
	private Integer tankSizeInGallons;
	
	@Column(name="aquarium_type")
	private String typeOfAquarium;
	
	@Column(name="amount_of_fish")
	private int totalAmountOfFish;
	
	@Column(name="amount_of_plants")
	private int totalAmountOfPlants;
	
	@Column(name="aquarium_start_date")
	private Date aquariumStartDate;

	@OneToMany(mappedBy = "aquarium")
	List<FishHasAquarium> fishInAquarium;
	
	public Aquarium() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Integer getTankSizeInGallons() {
		return tankSizeInGallons;
	}

	public void setTankSizeInGallons(Integer tankSizeInGallons) {
		this.tankSizeInGallons = tankSizeInGallons;
	}

	public String getTypeOfAquarium() {
		return typeOfAquarium;
	}

	public void setTypeOfAquarium(String typeOfAquarium) {
		this.typeOfAquarium = typeOfAquarium;
	}

	public int getTotalAmountOfFish() {
		return totalAmountOfFish;
	}

	public void setTotalAmountOfFish(int totalAmountOfFish) {
		this.totalAmountOfFish = totalAmountOfFish;
	}

	public int getTotalAmountOfPlants() {
		return totalAmountOfPlants;
	}

	public void setTotalAmountOfPlants(int totalAmountOfPlants) {
		this.totalAmountOfPlants = totalAmountOfPlants;
	}

	public Date getAquariumStartDate() {
		return aquariumStartDate;
	}

	public void setAquariumStartDate(Date aquariumStartDate) {
		this.aquariumStartDate = aquariumStartDate;
	}

	
	public List<FishHasAquarium> getFishInAquarium() {
		return fishInAquarium;
	}

	public void setFishInAquarium(List<FishHasAquarium> fishInAquarium) {
		this.fishInAquarium = fishInAquarium;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aquarium other = (Aquarium) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Aquarium [id=" + id + ", userId=" + userId + ", tankSizeInGallons=" + tankSizeInGallons
				+ ", typeOfAquarium=" + typeOfAquarium + ", totalAmountOfFish=" + totalAmountOfFish
				+ ", totalAmountOfPlants=" + totalAmountOfPlants + ", aquariumStartDate=" + aquariumStartDate
				+ ", fishInAquarium=" + fishInAquarium + "]";
	}
	
	
}
