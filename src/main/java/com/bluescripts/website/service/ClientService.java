package com.bluescripts.website.service;

import com.bluescripts.website.constants.StringConstants;
import com.bluescripts.website.entity.Client;
import com.bluescripts.website.repository.ClientRepository;
import com.bluescripts.website.request.ClientRequest;
import com.bluescripts.website.response.GenericResponse;
import com.bluescripts.website.utils.IdUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientService {

	private final ClientRepository clientRepository;

	public GenericResponse createClient(ClientRequest request) {

		String clientId= IdUtils.generateId(StringConstants.clientId_prefix);
		Client client= Client.builder().clientId(clientId).companyAddress(request.getCompanyAddress()).companyName(
				request.getCompanyName()).build();

		clientRepository.save(client);
		GenericResponse response=new GenericResponse();
		response.setMessage("client created successfully");
		return response;
	}
}
