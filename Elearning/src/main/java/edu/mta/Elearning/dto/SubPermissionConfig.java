package edu.mta.Elearning.dto;

import org.springframework.stereotype.Component;

@Component
public class SubPermissionConfig {

	private String name;
	
	private String title;
	
	private boolean value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SubPermissionConfig() {}
	
	public SubPermissionConfig(String _title, String _name,boolean _value) {
		this.name=_name;
		this.title=_title;
		this.value=_value;
	}
}
