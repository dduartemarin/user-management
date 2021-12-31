package com.innobyte.usermanagement.persistence.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.innobyte.usermanagement.persistence.model.Phone;
import com.innobyte.usermanagement.persistence.repository.PhoneRepository;

@Service
public class PhonePersistenceService {
	@Autowired
	private PhoneRepository phoneRepository;
	
	public Phone save(Phone phone) {
		return phoneRepository.save(phone);
	}
}
