package com.bluescripts.website.service;

import javax.xml.transform.sax.SAXTransformerFactory;

import com.bluescripts.website.constants.StringConstants;
import com.bluescripts.website.entity.Product;
import com.bluescripts.website.repository.ProductRepository;
import com.bluescripts.website.request.ProductRequest;
import com.bluescripts.website.response.GenericResponse;
import com.bluescripts.website.utils.IdUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

	public GenericResponse product(ProductRequest request) {

		String productId= IdUtils.generateId(StringConstants.productId_prefix);
		Product product= Product.builder().productId(productId).productName(request.getProductName()).build();

		productRepository.save(product);
		GenericResponse response=new GenericResponse();
		response.setMessage("product created successfully");
		return response;
	}
}
