package com.skilldistillery.jpaaquariumsite.entities;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	private int id;
	
	@Column(name="username")
	private String userName;
	
	private int age;
	
	private String location;
	
	@Column(name="profile_picture")
	private String profilePicture;
	
	@OneToMany(mappedBy = "user")
    List<UserHasAquarium> userAquariums;
	
	public User() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	public List<UserHasAquarium> getUserAquariums() {
		return userAquariums;
	}

	public void setUserAquariums(List<UserHasAquarium> userAquariums) {
		this.userAquariums = userAquariums;
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
		User other = (User) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", age=" + age + ", location=" + location
				+ ", profilePicture=" + profilePicture + ", userAquariums=" + userAquariums + "]";
	}
}
