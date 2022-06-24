package edu.mta.Elearning.object;

import java.util.ArrayList;
import java.util.List;

import edu.mta.Elearning.entity.BaseEntity;
import edu.mta.Elearning.entity.DbRole;
import edu.mta.Elearning.entity.DbUser;

public class Role  extends BaseObject{

	
	private DbRole dbRole;
	private List<User> Users;
	
	public Role(DbRole dbRole) {
		setDbRole(dbRole);
	}

	public DbRole getDbRole() {
		return dbRole;
	}
	
	public Role() {
		this(new DbRole());
	} 
	
	
	public int getId() {
		return dbRole.getId();
	}
	public void setId(int id) {
		dbRole.setId(id);
	}
	public String getName() {
		return dbRole.getName();
	}

	public void setName(String name) {
		dbRole.setName(name);
	}

	public Object getPermisssion() {
		return dbRole.getPermisssion();
	}

	public void setPermisssion(Object permisssion) {
		dbRole.setPermisssion(permisssion);
	}
	
	public List<User> getUsers() {
		if (Users == null) {
			Users = new ArrayList<User>();
			List<DbUser> list = dbRole.getUsers();
			if (list != null) {
				for (DbUser dbUser : list) {
					Users.add(new User(dbUser));
				}
			}
		}
		return Users;
	}

	public void setUsers(List<User> users) {
		this.Users = users;
		List<DbUser> result = null;
		if (users != null) {
			result = new ArrayList<DbUser>();
			for (User user : users) {
				result.add(user.getDbUser());
			}
		}
		dbRole.setUsers(result);
	}
	
	

	public void setDbRole(DbRole dbRole) {
		if (dbRole == null)
			throw new IllegalArgumentException("dbRole must not be null.");
		this.dbRole = dbRole;
	}
	
	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void finishUpdate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public BaseEntity getDbEntity() {
		// TODO Auto-generated method stub
		 return getDbRole();
	}

}
