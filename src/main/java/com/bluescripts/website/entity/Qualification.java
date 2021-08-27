package com.bluescripts.website.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Qualification implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer qId;
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
}
