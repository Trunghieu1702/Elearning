package edu.mta.Elearning.mgr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mta.Elearning.dao.BaseDao;
import edu.mta.Elearning.dao.CboxsDao;
import edu.mta.Elearning.entity.DbCboxs;
import edu.mta.Elearning.object.Cboxs;

@Component
public class CboxMgr extends BaseMgr{

	static CboxMgr instance;
	
	@Autowired
	private CboxsDao cboxDao;
	
	public CboxMgr() {
		super();
		instance = this;
	}
	
	@Override
	public BaseDao getDAO() {
		return cboxDao;
	}
	
	public static CboxMgr get() {
		return instance;
	}
	
	public List<Cboxs> getRoleAll() {
		List<DbCboxs> cboxs = cboxDao.getCboxsAll();
		List<Cboxs> result = new ArrayList<Cboxs>();
		if(cboxs==null) return result;
		for (DbCboxs dbCbox : cboxs) {
			result.add(new Cboxs(dbCbox));
		}
		return result;
	}
	
	public Cboxs getCboxById(long id) {
		DbCboxs cbox = cboxDao.getCboxsById(id);
		if(cbox==null) return null;

		return new Cboxs(cbox);
	}
	
	public List<Cboxs> getInforCboxs(long id,String folderName,String user_id) {
		List<DbCboxs> cboxs = cboxDao.getInforCboxs(id, folderName, user_id);
		List<Cboxs> result = new ArrayList<Cboxs>();
		if(cboxs==null) return result;
		for (DbCboxs dbCbox : cboxs) {
			result.add(new Cboxs(dbCbox));
		}
		return result;
	}
}
