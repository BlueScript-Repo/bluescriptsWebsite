package com.bluescripts.website.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Registration implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
//	private String email;
	private String firstName;
	private String middleName;
	private String lastName;
	private String DOB;
	//private String password;
	private String age;
	private String experience;
	private String companyName;
	private String strength;
	private String weakness;
	private long mobileNo;
	private long alternateMobileNo;
	private String primarySkills;
	@Lob
	private String currentAddress;
	@Lob
	private String permanentAddress;

	@OneToOne(targetEntity = Qualification.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "qId",referencedColumnName = "qId")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Qualification qualification;

	@OneToOne(targetEntity = Login.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "userName",referencedColumnName = "userName")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Login login;
}
