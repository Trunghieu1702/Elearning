package edu.mta.Elearning.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PermissionConfig {

	private String name;
	
	private List<Object> items;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Object> getItems() {
		return items;
	}

	public void setItems(List<Object> items) {
		this.items = items;
	}
	
	public PermissionConfig() {}
	
	
}
