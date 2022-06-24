package edu.mta.Elearning.mgr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mta.Elearning.dao.BaseDao;
import edu.mta.Elearning.dao.RoleDao;
import edu.mta.Elearning.entity.DbRole;
import edu.mta.Elearning.object.Role;

@Component
public class RoleMgr extends BaseMgr{

	static RoleMgr instance;
	
	@Autowired
	private RoleDao roleDao;
	
	public RoleMgr() {
		super();
		instance = this;
	}
	
	@Override
	public BaseDao getDAO() {
		return roleDao;
	}
	
	public static RoleMgr get() {
		return instance;
	}
	
	public List<Role> getRoleAll() {
		List<DbRole> roles = roleDao.getRoleAll();
		List<Role> result = new ArrayList<Role>();
		if(roles==null) return result;
		for (DbRole dbrole : roles) {
			result.add(new Role(dbrole));
		}
		return result;
	}
	
	public Role getRoleAll(int id) {
		DbRole role = roleDao.getRoleById(id);
		if(role==null) return null;

		return new Role(role);
	}
}
