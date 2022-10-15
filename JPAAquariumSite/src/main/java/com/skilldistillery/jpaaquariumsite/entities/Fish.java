package com.skilldistillery.jpaaquariumsite.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fish {

	@Id
	private int id;
	
	@Column(name="fish_name")
	private String fishName;

	@Column(name="max_fish_size_inches")
	private Double fishMaxSize;
	
	@Column(name="fish_type")
	private String fishType;
	
	@OneToMany(mappedBy = "fish")
	private List<FishHasAquarium> fishInAquarium;
	
	public Fish() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFishName() {
		return fishName;
	}

	public void setFishName(String fishName) {
		this.fishName = fishName;
	}

	public Double getFishMaxSize() {
		return fishMaxSize;
	}

	public void setFishMaxSize(Double fishMaxSize) {
		this.fishMaxSize = fishMaxSize;
	}

	public String getFishType() {
		return fishType;
	}

	public void setFishType(String fishType) {
		this.fishType = fishType;
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
		Fish other = (Fish) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Fish [id=" + id + ", fishName=" + fishName + ", fishMaxSize=" + fishMaxSize + ", fishType=" + fishType
				+ ", fishInAquarium=" + fishInAquarium + "]";
	}
	
}