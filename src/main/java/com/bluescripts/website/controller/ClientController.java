package com.bluescripts.website.controller;

import com.bluescripts.website.request.ClientRequest;
import com.bluescripts.website.response.GenericResponse;
import com.bluescripts.website.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class ClientController {

	private final ClientService clientService;

	@PostMapping
	public GenericResponse createClient(@RequestBody ClientRequest request){
		return clientService.createClient(request);
	}
}
