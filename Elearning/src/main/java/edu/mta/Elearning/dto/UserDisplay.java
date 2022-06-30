package edu.mta.Elearning.dto;


import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import edu.mta.Elearning.object.User;

@Component
public class UserDisplay {

	private String code;

	private String name;

	private String password;

	private String birthday;

	private String sex;

	private String address;

	private String email;

	private String phone_number;

	private String start_date;
	
	private Timestamp t_start_date;

	private int roleId;

	private String strRole;

	private int status;

	private int deleteflag;

	private String imgurl;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int role) {
		this.roleId = role;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(int deleteflag) {
		this.deleteflag = deleteflag;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getStrRole() {
		return strRole;
	}

	public void setStrRole(String strRole) {
		this.strRole = strRole;
	}

	
	
	public Timestamp getT_start_date() {
		return t_start_date;
	}

	public void setT_start_date(Timestamp t_start_date) {
		this.t_start_date = t_start_date;
	}

	public UserDisplay() {
	}

	public UserDisplay(User user) {
//		DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("mm-dd-yyyy");
		DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("YYYY-MM-dd");
//		DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");
		this.name = user.getName();
		this.code = user.getCode();
		this.address = user.getAddress();
		this.birthday = user.getBirthday().toLocalDateTime().format(FORMATTER);
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.phone_number = user.getPhone_number();
		this.roleId = user.getRoleId();
		this.sex = user.getSex();
		this.start_date = user.getStart_date().toLocalDateTime().format(FORMATTER);
		this.status = user.getStatus();
		this.imgurl = user.getImgurl();
		this.t_start_date = user.getStart_date();
	}

	public String getAvatarImagePath() {
		if (imgurl == null || code == null)
			return null;
		return "/Upload/Avatar/" + code + "/" + imgurl;
	}
}