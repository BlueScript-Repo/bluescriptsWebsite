package com.bluescripts.website.service;

import com.bluescripts.website.entity.Login;
import com.bluescripts.website.entity.Qualification;
import com.bluescripts.website.entity.Registration;
import com.bluescripts.website.repository.LoginRepository;
import com.bluescripts.website.repository.QualificationRepository;
import com.bluescripts.website.repository.RegistrationRepository;
import com.bluescripts.website.request.RegistrationRequest;
import com.bluescripts.website.response.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationService {

	private final LoginRepository loginRepository;
	private final QualificationRepository qualificationRepository;
	private final RegistrationRepository registrationRepository;
	private final PasswordEncoder passwordEncoder;

	public GenericResponse register(RegistrationRequest request) {

		GenericResponse response = new GenericResponse();
		if ((request.getPassword()).equals(request.getConfirmPassword())) {
			String role="USER";
			Qualification qualification = Qualification.builder().certification(request.getCertification()).degree(
					request.getDegree()).DegreeIn(request.getDegreeIn()).degreeInstitute(request.getDegreeInstitute())
					.deplomaInstitute(request.getDeplomaInstitute()).deplomaIn(request.getDeplomaIn())
					.deplomaPercentage(request.getDeplomaPercentage()).degreePercentage(request.getDegreePercentage())
					.degreePassoutYear(request.getDegreePassoutYear()).deplomaPassoutYear(
							request.getDeplomaPassoutYear()).tenthPercentage(request.getTenthPercentage())
					.twelthPercentage(request.getTwelthPercentage()).build();

			qualificationRepository.save(qualification);

			Login login = Login.builder().email(request.getUserName()).userName(request.getUserName()).password(
					passwordEncoder.encode(request.getPassword())).role(role).build();

			loginRepository.save(login);

			Qualification newQualification = qualificationRepository.findByqId(qualification.getQId());
			Login newLogin = loginRepository.findByUserName(login.getUserName()).orElse(null);

			Registration registration = Registration.builder().companyName(request.getCompanyName()).age(
					request.getAge()).firstName(request.getFirstName()).lastName(request.getLastName())
					.alternateMobileNo(request.getAlternateMobileNo()).mobileNo(request.getMobileNo()).DOB(
							request.getDOB()).experience(request.getExperience()).middleName(request.getMiddleName())
					.primarySkills(request.getPrimarySkills()).strength(request.getStrength()).weakness(
							request.getWeakness()).currentAddress(request.getCurrentAddress()).permanentAddress(
							request.getPermanentAddress()).qualification(newQualification).login(newLogin).build();

			registrationRepository.save(registration);

			response.setMessage("successfully Registered");
		} else {
			response.setMessage("incorrect password :" + request.getConfirmPassword());
		}
		return response;
	}
}
