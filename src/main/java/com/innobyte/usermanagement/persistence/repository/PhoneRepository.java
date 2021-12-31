package com.innobyte.usermanagement.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innobyte.usermanagement.persistence.model.Phone;


@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long>{

}

