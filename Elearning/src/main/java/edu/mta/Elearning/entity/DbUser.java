package edu.mta.Elearning.entity;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import edu.mta.Elearning.utils.StrUtils;

@Entity
@Table(name = "`user`", uniqueConstraints = { //
		@UniqueConstraint(name = "user_uk", columnNames = "email"),
		@UniqueConstraint(name = "user_uk_1", columnNames = "code")})
public class DbUser extends BaseEntity{

	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "user_id", nullable = false,columnDefinition = "VARCHAR(255)")
	@Type(type="org.hibernate.type.UUIDCharType")
	private UUID user_id;
	
	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "birthday")
	private Timestamp birthday;

	@Column(name = "sex")
	private String sex;

	@Column(name = "address")
	private String address;

	@Column(name = "email")
	private String email;

	@Column(name = "phone_number")
	private String phone_number;

	@Column(name = "start_date")
	private Timestamp start_date;

	@Column(name = "role")
	private String role;

	@Column(name = "status")
	private int status;

	@Column(name = "deleteflag")
	private int deleteflag;
	
	@Column(name = "imgurl")
	private String imgurl;
	
	public String getUserId() {
		return user_id.toString();
	}

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

	public Timestamp getBirthday() {
		return birthday;
	}

	public void setBirthday(Timestamp birthday) {
		this.birthday = birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = StrUtils.convertStringToTimestamp(birthday);
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

	public Timestamp getStart_date() {
		return start_date;
	}

	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = StrUtils.convertStringToTimestamp(start_date);
	}
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	
}
