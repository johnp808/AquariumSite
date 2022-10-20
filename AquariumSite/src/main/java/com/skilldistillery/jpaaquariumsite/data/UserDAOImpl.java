package com.skilldistillery.jpaaquariumsite.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpaaquariumsite.entities.Aquarium;
import com.skilldistillery.jpaaquariumsite.entities.User;

@Service
@Transactional
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<User> findAll() {
		String jpql = "SELECT user FROM User user";
		List<User> user = em.createQuery(jpql, User.class).getResultList();
		return user;
	}

	@Override
	public User findById(int userId) {
		return em.find(User.class, userId);
	}

	@Override
	public User createUser(User user) {
		em.persist(user);
		em.flush();
		em.close();
		return user;
	}

	@Override
	public User updateUser(int userId, User user) {
		User dbUser = em.find(User.class, userId);
		dbUser.setUserName(user.getUserName());
		dbUser.setAge(user.getAge());
		dbUser.setLocation(user.getLocation());
		dbUser.setProfilePicture(user.getProfilePicture());
		em.flush();
		em.close();
		return dbUser;
	}

	@Override
	public boolean deleteUser(int userId) {
		boolean success = false;
		User user = em.find(User.class, userId);
		if(user != null) {
			em.remove(user);
			success = !em.contains(user);
		}
		em.close();
		return success;
	}

}
