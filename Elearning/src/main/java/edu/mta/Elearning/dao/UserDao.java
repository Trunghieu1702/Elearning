package edu.mta.Elearning.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import edu.mta.Elearning.entity.DbUser;

@Repository
@Transactional
public class UserDao extends BaseDao{

	

	public DbUser findUserAccount(String userName) {
		try {
			String sql = "Select e from " + DbUser.class.getName() + " e " //
					+ " Where e.code = :userName ";

			Query query = entityManager.createQuery(sql, DbUser.class);
			query.setParameter("userName", userName);

			return (DbUser) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public void persist(UserDao nv) {
		entityManager.persist(nv);
	}

}
