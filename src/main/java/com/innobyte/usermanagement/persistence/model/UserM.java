package com.innobyte.usermanagement.persistence.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserM implements Serializable {
	private static final long serialVersionUID = -8405729317935182661L;
	
	/**
	 * Id del usuario
	 */	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;

	/**
	 * nombre del usuario
	 * 
	 */
	private String name;
	
	/**
	 * Correo del usuario
	 * 
	 */
	private String email;

	/**
	 * Contraseña del usuario
	 * 
	 */
	private String password;
		
	/**
	 * token del usuario
	 * 
	 */
	private String token;	
	
	/**
	 * lastLoginTimestamp en que se cambio el passsword
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@UpdateTimestamp
	private LocalDateTime lastLoginTimestamp;

	/**
	 * Timestamp en que se crea el registro
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@CreationTimestamp
	private LocalDateTime createdTimestamp;

	/**
	 * Timestamp en que se actualiza el registro
	 */
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@UpdateTimestamp
	private LocalDateTime updatedTimestamp;
		
	/**
	 * Indicador que el usuario está activo
	 */
	private boolean isActive;
	
	/**
	 * Relacion con la tabla phone
	 * 
	 */	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userm")
    private List<Phone> phone;
}
