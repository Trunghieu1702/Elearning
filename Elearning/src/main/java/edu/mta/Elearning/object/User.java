package edu.mta.Elearning.object;

import java.sql.Timestamp;


import edu.mta.Elearning.entity.BaseEntity;
import edu.mta.Elearning.entity.DbUser;
import edu.mta.Elearning.utils.StrUtils;

public class User extends BaseObject implements BaseUser{

	private DbUser dbUser;
	
	@Override
	public String getUsername() {
		dbUser.getCode();
		return null;
	}

	public DbUser getDbUser() {
		return dbUser;
	}

	public void setDbUser(DbUser dbUser) {
		this.dbUser = dbUser;
	}

	public User() {
		this(new DbUser());
	}
	
	public User(DbUser dbUser) {
		setDbUser(dbUser);
	}
//	public void setUser(UserDisplay user) {
//		
//		setAddress(user.getAddress());
//		setBirthday(user.getBirthday());
////		setCode(user.getCode());
//		setEmail(user.getEmail());
//		setName(user.getName());
//		setPassword(user.getPassword());
//		setPhone_number(user.getPhone_number());
//		setRole(user.getRole());
//		setSex(user.getSex());
//		setStart_date(user.getStart_date());
//		setStatus(user.getStatus());
//	}
	/*
	 * addd method
	 */
	
	public String getCode() {
		return dbUser.getCode();
	}

	public void setCode(String code) {
		dbUser.setCode(code);
	}

	public String getName() {
		return dbUser.getName();
	}

	public void setName(String name) {
		dbUser.setName(name);
	}

	public String getPassword() {
		return dbUser.getPassword();
	}

	public void setPassword(String password) {
		dbUser.setPassword(password);
	}

	public Timestamp getBirthday() {
		return dbUser.getBirthday();
	}

	public void setBirthday(Timestamp birthday) {
		dbUser.setBirthday(birthday);
	}
	
	public void setBirthday(String birthday) {
		dbUser.setBirthday(birthday);
	}

	public String getSex() {
		return dbUser.getSex();
	}

	public void setSex(String sex) {
		dbUser.setSex(sex);
	}

	public String getUserId() {
		return dbUser.getUserId();
	}
	
	public String getAddress() {
		return dbUser.getAddress();
	}

	public void setAddress(String address) {
		dbUser.setAddress(address);
	}

	public String getEmail() {
		return dbUser.getEmail();
	}

	public void setEmail(String email) {
		dbUser.setEmail(email);
	}

	public String getPhone_number() {
		return dbUser.getPhone_number();
	}

	public void setPhone_number(String phone_number) {
		dbUser.setPhone_number(phone_number);
	}

	public Timestamp getStart_date() {
		return dbUser.getStart_date();
	}

	public void setStart_date(Timestamp start_date) {
		dbUser.setStart_date(start_date);
	}
	
	public void setStart_date(String start_date) {
		dbUser.setStart_date(start_date);
	}

	public int getRoleId() {
		return dbUser.getRoleId();
	}

	public void setRoleId(int role) {
		dbUser.setRoleId(role);
	}

	public int getStatus() {
		return dbUser.getStatus();
	}

	public void setStatus(int status) {
		dbUser.setStatus(status);
	}

	public int getDeleteflag() {
		return dbUser.getDeleteflag();
	}

	public void setDeleteflag(int deleteflag) {
		dbUser.setDeleteflag(deleteflag);
	}
	
	public String getImgurl() {
		return dbUser.getImgurl();
	}

	public void setImgurl(String imgurl) {
		dbUser.setImgurl(imgurl);
	}
	
	@Override
	public BaseEntity getDbEntity() {
		return getDbUser();
	}
	
	@Override
	public boolean validate() {
		return validateUsername()&& validateEmail();
	}

	@Override
	public void finishUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean validateUsername() {
		// Name must not be empty or null
		String name = getUsername();
		return name != null && name.length() > 0;
	}
	
	public boolean validateEmail() {
		return StrUtils.isEmailAddress(getEmail());
	}

	@Override
	public int getRole() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
