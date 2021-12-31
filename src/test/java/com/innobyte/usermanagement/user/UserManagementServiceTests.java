package com.innobyte.usermanagement.user;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserManagementServiceTests {

	@Test
	void contextLoads() {
	}


	@Test
	void testUsingUnicodeRegexEmail() {
	    String emailAddress = "deyanirethd@gmail.com";
	    String regexPattern = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	    assertTrue(emailAddress.matches(regexPattern));
	}
	
	@Test
	void testUsingUnicodeRegexPassword() {
	    String password = "eafRY8ZGvk*";
	    String regexPattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
	    assertTrue(password.matches(regexPattern));
	}
}
