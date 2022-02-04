package com.jove.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jove.demo.controller.HomeController;
import com.jove.demo.models.User;



public class UserTest {
	private static Validator validator;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@BeforeAll
	public static void setUpValidator() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
    public void userIsNotValidWhenLenthError() {
		User user = new User();
		user.setPassword("1");
		user.setUserName("1");
		Set<ConstraintViolation<User>> constraintViolations =
                validator.validate( user );

		Iterator<ConstraintViolation<User>> itr = constraintViolations.iterator();
		while(itr.hasNext()) {
			logger.debug("error message" + itr.next().getMessage());
		}
		
		assertEquals( 2 , constraintViolations.size() );		
	}
	
	@Test
    public void userIsNotValidWhenAllBlank() {
		User user = new User();
		user.setPassword("");
		user.setUserName("");
		Set<ConstraintViolation<User>> constraintViolations =
                validator.validate( user );
		
		Iterator<ConstraintViolation<User>> itr = constraintViolations.iterator();
		while(itr.hasNext()) {
			logger.debug("error message" + itr.next().getMessage());
		}
		
		assertEquals( 4 , constraintViolations.size() );
	}	

}
