package com.innobyte.usermanagement.persistence.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.innobyte.usermanagement.persistence.model.UserM;
import com.innobyte.usermanagement.persistence.repository.UserMRepository;

import com.innobyte.usermanagement.resources.DataDuplicatedException;
import com.innobyte.usermanagement.resources.DataNotFoundException;

@Service
public class UserMPersistenceService {
	@Autowired
	private UserMRepository userMRepository;
	
	public UserM findById(Long id) throws DataNotFoundException {
		Optional<UserM> result = userMRepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			throw new DataNotFoundException("No se encontró el usuario: " + id.toString());
		}
	}
	
	public void existsByEmail(String email) throws DataDuplicatedException {
		List<UserM> result = userMRepository.findByEmail(email);
		if (!result.isEmpty()) {
			throw new DataDuplicatedException("Email " + email + " ya existe");
		}
	}
	
	public UserM save(UserM contact) {
		return userMRepository.save(contact);
	}
	
	public List<Map<String, Object>> getUsersActive() {		
		return userMRepository.findByIsActive();
	}
}
