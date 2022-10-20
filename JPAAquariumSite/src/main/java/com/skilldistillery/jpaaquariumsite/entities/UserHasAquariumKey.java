package com.skilldistillery.jpaaquariumsite.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserHasAquariumKey implements Serializable {

	@Column(name="user_id")
	private int userId;
	
	@Column(name="aquarium_id")
	private int aquariumId;
	
	public UserHasAquariumKey() {}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAquariumId() {
		return aquariumId;
	}

	public void setAquariumId(int aquariumId) {
		this.aquariumId = aquariumId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aquariumId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserHasAquariumKey other = (UserHasAquariumKey) obj;
		return aquariumId == other.aquariumId && userId == other.userId;
	}

}
