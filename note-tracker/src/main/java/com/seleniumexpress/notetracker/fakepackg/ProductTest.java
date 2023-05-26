package com.seleniumexpress.notetracker.fakepackg;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class ProductTest {
	
	FakeProductService fakeProductService;
	
	
	
	public void testProduct() {
		
		Product product = fakeProductService.getProductById(1);
		
		log.info(">>>>>>>>>>> " + product);
		
		
	}
}








//