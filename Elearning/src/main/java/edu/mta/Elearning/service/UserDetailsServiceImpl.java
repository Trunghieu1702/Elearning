package edu.mta.Elearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.mta.Elearning.dao.RoleDao;
import edu.mta.Elearning.dao.UserDao;
import edu.mta.Elearning.entity.DbRole;
import edu.mta.Elearning.entity.DbUser;
import edu.mta.Elearning.object.CtxUser;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		DbUser dbuser = this.userDao.findUserAccount(userName);

		if (dbuser == null) {
			System.out.println("User not found! " + userName);
			throw new UsernameNotFoundException("User " + userName + " was not found in the database");
		}
		DbRole dbRole = this.roleDao.getRoleById(dbuser.getRoleId());
		if (dbRole == null) {
			System.out.println("Role of "+ userName +"not found! ");
			throw new UsernameNotFoundException("Role of" + userName + " was not found in the database");
		}
		return (UserDetails) new CtxUser(dbuser,dbRole);
	}

}
