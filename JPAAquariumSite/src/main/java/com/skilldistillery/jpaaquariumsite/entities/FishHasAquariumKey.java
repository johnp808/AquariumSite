package com.skilldistillery.jpaaquariumsite.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FishHasAquariumKey implements Serializable {

	@Column(name="fish_id")
	private int fishId;
	
	@Column(name="aquarium_id")
	private int aquariumId;
	
	public FishHasAquariumKey() {}

	public int getFishId() {
		return fishId;
	}

	public void setFishId(int fishId) {
		this.fishId = fishId;
	}

	public int getAquariumId() {
		return aquariumId;
	}

	public void setAquariumId(int aquariumId) {
		this.aquariumId = aquariumId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aquariumId, fishId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FishHasAquariumKey other = (FishHasAquariumKey) obj;
		return aquariumId == other.aquariumId && fishId == other.fishId;
	}
	
}
