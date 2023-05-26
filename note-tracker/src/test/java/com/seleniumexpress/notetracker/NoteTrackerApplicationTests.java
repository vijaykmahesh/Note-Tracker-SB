package com.seleniumexpress.notetracker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NoteTrackerApplicationTests {

	@Test
	void testCopyBeanUtils() {
		
		
		PersonDTO personDTO = new PersonDTO();
		personDTO.setId(1);
		personDTO.setName("Abhilash");
		personDTO.setAddress("India");
		
		PersonEntity personEntity = new PersonEntity();
		
		//copy the data
		BeanUtils.copyProperties(personDTO, personEntity);
		
		System.out.println(personEntity);
		
	}

}
