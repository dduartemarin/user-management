package com.innobyte.usermanagement.persistence.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.innobyte.usermanagement.persistence.model.UserM;

@Repository
public interface UserMRepository extends JpaRepository<UserM, Long>{
	UserMRepository findOneById(Long id);
	
	@Query( value = "SELECT co from UserM co where co.email = ?1")
	List<UserM> findByEmail(String email);
	
	@Query( value = "SELECT co.name, co.email, co.token from UserM co where co.isActive = true")
	List<Map<String, Object>> findByIsActive();
}
