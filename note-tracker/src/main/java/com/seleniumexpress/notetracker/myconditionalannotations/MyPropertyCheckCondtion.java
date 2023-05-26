package com.seleniumexpress.notetracker.myconditionalannotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD })
@ConditionalOnProperty(prefix ="notetracker",name = "service.noteTrackerService.enable",havingValue = "true")
public @interface MyPropertyCheckCondtion {

}
