package com.bluescripts.website.request;

import lombok.Data;

@Data
public class RegistrationRequest {

	private String firstName;
	private String middleName;
	private String lastName;
	private String DOB;
	private String age;
	private String experience;
	private String companyName;
	private String strength;
	private String weakness;
	private long mobileNo;
	private long alternateMobileNo;
	private String primarySkills;
	private String currentAddress;
	private String permanentAddress;

	private float tenthPercentage;
	private float twelthPercentage;
	private float deplomaPercentage;
	private String deplomaInstitute;
	private String deplomaPassoutYear;
	private String deplomaIn;
	private String degreeInstitute;
	private String degree;
	private String degreePassoutYear;
	private String DegreeIn;
	private float degreePercentage;
	private String certification;

	private String userName;
	private String password;
	private String confirmPassword;

}
