package edu.mta.Elearning.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PermissionConfig {

	private String name;
	
	private String title;
	
	private List<SubPermissionConfig> items;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<SubPermissionConfig> getItems() {
		return items;
	}

	public void setItems(List<SubPermissionConfig> items) {
		this.items = items;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PermissionConfig() {}
	
	public PermissionConfig(String name,String title) {
		this.title=title;
		this.name= name;
		if(name=="system") {
			List<SubPermissionConfig> subs = new ArrayList<SubPermissionConfig>();
			subs.add(new SubPermissionConfig("header","header",false));
			subs.add(new SubPermissionConfig("người dùng","user",false));
			subs.add(new SubPermissionConfig("quyền","role",false));
			subs.add(new SubPermissionConfig("nhóm","group",false));
			this.items= subs;
		}
		if(name=="content") {
			List<SubPermissionConfig> subs = new ArrayList<SubPermissionConfig>();
			subs.add(new SubPermissionConfig("header","header",false));
			this.items= subs;
		}
		if(name=="subject") {
			List<SubPermissionConfig> subs = new ArrayList<SubPermissionConfig>();
			subs.add(new SubPermissionConfig("header","header",false));
			this.items= subs;
		}
	}
	
	
}
