package com.skilldistillery.jpaaquariumsite.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="user_has_aquarium")
public class UserHasAquarium {

	@EmbeddedId
	UserHasAquariumKey id;
	
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	User user;
	
	
	@ManyToOne
	@MapsId("aquariumId")
	@JoinColumn(name = "aquarium_id")
	Aquarium aquarium;
	
	public UserHasAquarium() {}

	public UserHasAquariumKey getId() {
		return id;
	}

	public void setId(UserHasAquariumKey id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Aquarium getAquarium() {
		return aquarium;
	}

	public void setAquarium(Aquarium aquarium) {
		this.aquarium = aquarium;
	}
	
	
}
