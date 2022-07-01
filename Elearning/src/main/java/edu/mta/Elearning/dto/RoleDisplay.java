package edu.mta.Elearning.dto;

import org.springframework.stereotype.Component;

import edu.mta.Elearning.object.Role;

@Component
public class RoleDisplay {


	private int id;
	

	private String name; 
	

	private Object permisssion;


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
	
	public RoleDisplay() {}
	
	public RoleDisplay(Role role) {
		
		this.id = role.getId();
		this.name = role.getName();
		this.permisssion = role.getPermisssion();
	}
}
