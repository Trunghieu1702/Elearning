package edu.mta.Elearning.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

	@Column(name = "roleId")
	private int roleId;

	@Column(name = "status")
	private int status;

	@Column(name = "deleteflag")
	private int deleteflag;
	
	@Column(name = "imgurl")
	private String imgurl;
	
	@OneToMany(mappedBy = "user_id", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbCboxs> cboxs = new ArrayList<DbCboxs>();
	
	@OneToMany(mappedBy = "user_id", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbContents> contents = new ArrayList<DbContents>();
	
	@OneToMany(mappedBy = "user_id", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbLogChapters> logChapters = new ArrayList<DbLogChapters>();
	
	@OneToMany(mappedBy = "user_id", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbLogSubjects> logSubjects = new ArrayList<DbLogSubjects>();
	
	@OneToMany(mappedBy = "user_id", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbLogUnits> logUnits = new ArrayList<DbLogUnits>();
	
	@OneToMany(mappedBy = "user_id", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbLogUnitTests> logunittests = new ArrayList<DbLogUnitTests>();
	
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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public UUID getUser_id() {
		return user_id;
	}

	public void setUser_id(UUID user_id) {
		this.user_id = user_id;
	}

	public List<DbCboxs> getCboxs() {
		return cboxs;
	}

	public void setCboxs(List<DbCboxs> cboxs) {
		this.cboxs = cboxs;
	}

	public List<DbContents> getContents() {
		return contents;
	}

	public void setContents(List<DbContents> contents) {
		this.contents = contents;
	}

	public List<DbLogChapters> getLogChapters() {
		return logChapters;
	}

	public void setLogChapters(List<DbLogChapters> logChapters) {
		this.logChapters = logChapters;
	}

	public List<DbLogSubjects> getLogSubjects() {
		return logSubjects;
	}

	public void setLogSubjects(List<DbLogSubjects> logSubjects) {
		this.logSubjects = logSubjects;
	}

	public List<DbLogUnits> getLogUnits() {
		return logUnits;
	}

	public void setLogUnits(List<DbLogUnits> logUnits) {
		this.logUnits = logUnits;
	}

	public List<DbLogUnitTests> getLogunittests() {
		return logunittests;
	}

	public void setLogunittests(List<DbLogUnitTests> logunittests) {
		this.logunittests = logunittests;
	}
}
