package edu.mta.Elearning.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mta.Elearning.entity.DbRole;

@Repository
@Transactional
public class RoleDao extends BaseDao{

	
	@SuppressWarnings("unchecked")
	public List<DbRole> getRoleAll() {
		try {
			String sql = "Select e from " + DbRole.class.getName() + " e " ;
			Query query = entityManager.createQuery(sql, DbRole.class);

			return (List<DbRole>) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public DbRole getRoleById(int id) {
		try {
			String sql = "Select e from " + DbRole.class.getName() + " e " 
					+ " Where e.id = :id ";
			Query query = entityManager.createQuery(sql, DbRole.class);
			query.setParameter("id", id);
			return (DbRole) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public void persist(RoleDao role) {
		entityManager.persist(role);
	}
}
