package com.bluescripts.website.controller;

import com.bluescripts.website.request.ProductRequest;
import com.bluescripts.website.response.GenericResponse;
import com.bluescripts.website.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;

	@PostMapping
	public GenericResponse product(@RequestBody ProductRequest request){
		return productService.product(request);
	}

}
