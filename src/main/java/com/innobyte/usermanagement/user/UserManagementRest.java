package com.innobyte.usermanagement.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.innobyte.usermanagement.resources.DataDuplicatedException;
import com.innobyte.usermanagement.resources.DataNotSavedException;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/userManagement")
public class UserManagementRest {
	private static final String RESULT_RESP="result";
	private static final String DESCRIPTION_RESP= "Mensaje";
	
	@Autowired
	UserManagementService userSvc;
	
	@ApiOperation("Crear usuario")
	@PostMapping(path = "/CreateUser")
	public ResponseEntity<Map<String, Object>> userBasicRegistry(@RequestBody UserDTO user) {
		Map<String, Object> response = new HashMap<>();
		try {
			return new ResponseEntity<>(
					userSvc.basicUserRegistry(user), HttpStatus.OK);
		} catch (DataDuplicatedException | DataNotSavedException e) {
			log.error(e.getMessage(), e.getMessage());
			response.put(RESULT_RESP, 1);
			response.put(DESCRIPTION_RESP, e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
}
