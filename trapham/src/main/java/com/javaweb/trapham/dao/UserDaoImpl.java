package com.javaweb.trapham.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.trapham.entity.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insert(User user) throws SQLException {
		entityManager.persist(user);
	}

	@Override
	public void update(User user) throws SQLException {
		entityManager.merge(user);
	}

	@Override
	public void delete(User user) {
		entityManager.remove(user);
	}

	@Override
	public User searchUserById(int id) {
		String jql = "SELECT u FROM User u WHERE u.id = :id";
		
		User user = null;
		
		try {
			user = entityManager.createQuery(jql, User.class).setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return user;
	}

	@Override
	public User searchUserByUserName(String string) {
		String jql = "SELECT u FROM User u WHERE u.userName = :string";
		
		User user = null;
		
		try {
			user = entityManager.createQuery(jql, User.class).setParameter("string", string).getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return user;
	}

	@Override
	public List<User> searchUserByName(String string) {
		String jql = "SELECT u FROM User u WHERE u.name = :string";
		
		List<User> list = null;
		
		try {
			list = entityManager.createQuery(jql, User.class).setParameter("string", string).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public List<User> searchUserAll() {
		String jql = "SELECT u FROM User u";
		
		List<User> list = null;
		
		try {
			list = entityManager.createQuery(jql, User.class).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public List<User> searchUserMember() {
		String jql = "SELECT u FROM User u WHERE u.role = :string";
		
		List<User> list = null;
		
		try {
			list =entityManager.createQuery(jql, User.class).setParameter("string", "ROLE_USER").getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public List<User> searchUserAdmin() {
		String jql = "SELECT u FROM User u WHERE u.role = :string";
		
		List<User> list = null;
		
		try {
			list = entityManager.createQuery(jql, User.class).setParameter("string", "ROLE_ADMIN").getResultList();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}

	@Override
	public void deleteImg(User user) {
		
	}

	@Override
	public long countMemberUser() {
		String jql = "SELECT COUNT(u.id) FROM User u where u.role = :string";
		
		Long long1 = 0l;
		
		try {
			long1 = entityManager.createQuery(jql, Long.class).setParameter("string", "ROLE_USER").getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return long1;
	}
}
