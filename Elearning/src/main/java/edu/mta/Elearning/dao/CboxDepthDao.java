package edu.mta.Elearning.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mta.Elearning.entity.DbCboxDepth;

@Repository
@Transactional
public class CboxDepthDao extends BaseDao{
	
    @SuppressWarnings("unchecked")
	public List<DbCboxDepth> getCboxDepthAll() {
        try {
            String sql = "Select e from " + DbCboxDepth.class.getName() + " e " ;
            Query query = entityManager.createQuery(sql, DbCboxDepth.class);

            return (List<DbCboxDepth>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
 
	public DbCboxDepth getCboxDepthById(long id) {
        try {
            String sql = "Select e from " + DbCboxDepth.class.getName() + " e "
            		+ " where e.id =:id" ;
            Query query = entityManager.createQuery(sql, DbCboxDepth.class);
            query.setParameter("id", id);

            return (DbCboxDepth) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public void persist(CboxDepthDao cboxDepth) {
		entityManager.persist(cboxDepth);
	}
}
