package edu.mta.Elearning.mgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mta.Elearning.dao.BaseDao;
import edu.mta.Elearning.dao.CboxDepthDao;

@Component
public class CboxDepthMgr extends BaseMgr{

	static CboxDepthMgr instance;
	
	@Autowired
	private CboxDepthDao cboxDepthDao;
	
	public CboxDepthMgr() {
		super();
		instance = this;
	}
	
	@Override
	public BaseDao getDAO() {
		return cboxDepthDao;
	}
	
	public static CboxDepthMgr get() {
		return instance;
	}

}
