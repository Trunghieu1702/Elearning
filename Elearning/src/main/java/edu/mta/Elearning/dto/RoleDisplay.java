package edu.mta.Elearning.dto;

import java.util.ArrayList;
import java.util.List;

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
		if(permisssion==null) {
			List<PermissionConfig> configs = new ArrayList<PermissionConfig>();
			configs.add(new PermissionConfig("system","Hệ Thống"));
			configs.add(new PermissionConfig("content","Nội Dung"));
			configs.add(new PermissionConfig("subject","Bài Học"));
			permisssion = configs;
			return permisssion;
		}
		return permisssion;
	}


	public void setPermisssion(Object permisssion) {
		if(permisssion== null) {
			List<PermissionConfig> configs = new ArrayList<PermissionConfig>();
			configs.add(new PermissionConfig("system","Hệ Thống"));
			configs.add(new PermissionConfig("content","Nội Dung"));
			configs.add(new PermissionConfig("subject","Bài Học"));
			this.permisssion = configs;
		}
		this.permisssion = permisssion;
	}
	
	public RoleDisplay() {
		this.permisssion = getPermisssion();
	}
	
	public RoleDisplay(Role role) {
		
		this.id = role.getId();
		this.name = role.getName();
		this.permisssion = role.getPermisssion();
	}
}
