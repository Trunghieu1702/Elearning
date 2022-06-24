package edu.mta.Elearning.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;


@Entity
@Table(name = "role", uniqueConstraints = { //
		@UniqueConstraint(name = "role_uk", columnNames = "name")})
public class DbRole extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name; 
	
	@Column(name = "permisssion")
	@Type(type = "jsonb")
	private Object permisssion;
	
	@OneToMany(mappedBy = "roleId", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<DbUser> users = new ArrayList<DbUser>();

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getPermisssion() {
		return permisssion;
	}

	public void setPermisssion(Object permisssion) {
		this.permisssion = permisssion;
	}
	
	public List<DbUser> getUsers() {
		return users;
	}

	public void setUsers(List<DbUser> users) {
		this.users = users;
	}

}
