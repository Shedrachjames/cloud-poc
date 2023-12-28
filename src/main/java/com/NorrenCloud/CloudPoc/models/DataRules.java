package com.NorrenCloud.CloudPoc.models;

public class DataRules {
	// last name rule
	public static String lastNameRule(String lastname) {
		return lastname.toUpperCase().trim();
	}

	// first and middle name rule
	public static  String firstOrMiddleNameRule(String nam) {
		String name=nam.trim();
		return name.substring(0, 1).toUpperCase().trim() + name.substring(1).toLowerCase().trim();
	}
	

	// email rule
	public static String emailRule(String emai) {
		String email=emai.trim();
		return email.toLowerCase().trim();
	}
	
	//other details
	public static String othersRule(String others) {
		return others.toLowerCase().trim();
	}
}
