package com.cao.app.widgets.listadpater;

public class Contact {
	private String name;
	private String phoneNumber;
	private String size;
	private String icon;
	
	public Contact(String name, String phoneNumber, String size) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.size = size;
		this.icon = "people.png";
	}
	
	
	public String getName() {
		return name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getSize() {
		return size;
	}
	
	public String getIcon() {
		return icon;
	}
}
