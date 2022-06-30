package edu.mta.Elearning.mgr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import edu.mta.Elearning.dao.BaseDao;
import edu.mta.Elearning.dao.UserDao;
import edu.mta.Elearning.entity.DbUser;
import edu.mta.Elearning.object.CtxUser;
import edu.mta.Elearning.object.User;

@Component
public class UserMgr extends BaseMgr{

	static UserMgr instance;
	
	@Autowired
	private UserDao userDao;
	
	public UserMgr() {
		super();
		instance = this;
	}
	
	@Override
	public BaseDao getDAO() {
		return userDao;
	}
	
	public static UserMgr get() {
		return instance;
	}
	
	public User findUserAccount(String username) {
		DbUser nv = userDao.findUserAccount(username);
		if(nv==null) return new User();
		return new User(nv);
	}
	
	@SuppressWarnings("unused")
	public List<User> getAll() {
		List<DbUser> dbUsers = userDao.getAll();
		List<User> users = new ArrayList<User>();
		if(users==null) return users;
		for (DbUser dbUser : dbUsers) {
			users.add(new User(dbUser));
		}
		return users;
	}
	
	public CtxUser getContextUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			try {
				return (CtxUser) authentication.getPrincipal();
			} catch (ClassCastException e) {
				return null;
			}
		}
		return null;
	}
}