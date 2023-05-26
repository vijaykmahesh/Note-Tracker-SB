package com.seleniumexpress.notetracker.autoconfigure;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;

import com.seleniumexpress.notetracker.autoconfigure.conditions.MyCondition2;
import com.seleniumexpress.notetracker.dao.NoteDAO;
import com.seleniumexpress.notetracker.dao.NoteDAOImpl;
import com.seleniumexpress.notetracker.myconditionalannotations.MyPropertyCheckCondtion;
import com.seleniumexpress.notetracker.service.NoteTrackerService;
import com.seleniumexpress.notetracker.service.NoteTrackerServiceImpl;

//@AutoConfiguration (after = NoteTrackerAppAutoConfiguration2.class)

//@AutoConfigureAfter(NoteTrackerAppAutoConfiguration2.class)
//@ConditionalOnResource(resources = "classpath:application.properties")
//@ConditionalOnClass(MyCondition2.class)
public class NoteTrackerAppAutoConfiguration {
	
	
//	@Bean
//	@MyPropertyCheckCondtion	
//	NoteTrackerService noteTrackerService(NoteDAO noteDAO) {
//		
//		return new NoteTrackerServiceImpl(noteDAO);
//	}
	
	//@ConditionalOnMissingBean(value = {Test.class,Test2.class})
	
	

	//@ConditionalOnMissingClass("com.seleniumexpress.notetracker.controllers.Test3")
	
//	@Bean
//	@ConditionalOnWebApplication
//	@ConditionalOnBean(name = {"test"})
//	NoteDAO noteDAO() {
//		
//		return new NoteDAOImpl();
//	}
//	
	
	
	

}
