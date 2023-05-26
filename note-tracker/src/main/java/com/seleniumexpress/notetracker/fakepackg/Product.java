package com.seleniumexpress.notetracker.fakepackg;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Product {
	
	private int productId;
	private String productName;
	private int price;

}
