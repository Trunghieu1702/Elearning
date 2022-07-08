package edu.mta.Elearning.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mta.Elearning.entity.DbCboxs;

@Repository
@Transactional
public class CboxsDao extends BaseDao{

    @SuppressWarnings("unchecked")
	public List<DbCboxs> getCboxsAll() {
        try {
            String sql = "Select e from " + DbCboxs.class.getName() + " e " ;
            Query query = entityManager.createQuery(sql, DbCboxs.class);

            return (List<DbCboxs>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public DbCboxs getCboxsById(long id) {
        try {
            String sql = "Select e from " + DbCboxs.class.getName() + " e "
            		+ " where id=:id" ;
            Query query = entityManager.createQuery(sql, DbCboxs.class);
            query.setParameter("id", id);
            return (DbCboxs) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


	@SuppressWarnings("unchecked")
	public List<DbCboxs> getInforCboxs(long id,String folderName,String user_id) {
        try {
            String sql =String.format( "Select e from " + DbCboxs.class.getName() + " e "
            		+ " where e.ParentId = %s"
            		+ "%s"
            		+ "%s",
            		id,
            		(folderName == null?"":" and e.FolderName =:folderName"),
            		(user_id == null?"":" and e.user_id ='"+user_id+"'")) ;
            Query query = entityManager.createQuery(sql, DbCboxs.class);
            if(folderName != null) {
            	query.setParameter("folderName", folderName);
            }
            return (List<DbCboxs>) query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }
    public void persist(CboxsDao cbox) {
		entityManager.persist(cbox);
	}
}
