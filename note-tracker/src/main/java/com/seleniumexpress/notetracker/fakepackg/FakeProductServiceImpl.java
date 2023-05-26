package com.seleniumexpress.notetracker.fakepackg;

import org.springframework.stereotype.Service;

@Service
public class FakeProductServiceImpl implements FakeProductService {

	@Override
	public Product getProductById(int productId) {
		
		
		return Product.builder()
				.productId(productId)
				.productName("iphone")
				.price(200)
				.build();
	}

}
