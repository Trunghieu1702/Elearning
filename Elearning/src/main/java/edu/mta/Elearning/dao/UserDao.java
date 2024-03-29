package edu.mta.Elearning.dao;

import java.util.List;

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
					+ " Where e.code = :userName "
					+ " And e.deleteflag=0"
					+ "	And e.status =  0";

			Query query = entityManager.createQuery(sql, DbUser.class);
			query.setParameter("userName", userName);

			return (DbUser) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<DbUser> getAll() {
		try {
			String sql = "Select e from " + DbUser.class.getName() + " e "
					+"where e.deleteflag=0"
					+ " order by e.roleId,e.name";

			Query query = entityManager.createQuery(sql, DbUser.class);

			return (List<DbUser>) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<DbUser> getAllByCode(List<String> codes) {
		try {
			String sql = "Select e from " + DbUser.class.getName() + " e "
					+"where e.deleteflag=0"
					+ " and e.code in :codes";

			Query query = entityManager.createQuery(sql, DbUser.class);
			query.setParameter("codes", codes);

			return (List<DbUser>) query.getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public void persist(UserDao nv) {
		entityManager.persist(nv);
	}

}
