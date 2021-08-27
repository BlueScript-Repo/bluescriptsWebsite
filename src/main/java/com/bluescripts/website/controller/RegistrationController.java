package com.bluescripts.website.controller;

import com.bluescripts.website.request.RegistrationRequest;
import com.bluescripts.website.response.GenericResponse;
import com.bluescripts.website.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {

	private final RegistrationService service;

	@PostMapping
	public GenericResponse register(@RequestBody RegistrationRequest request) {
		return service.register(request);
	}
}
