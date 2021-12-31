package com.innobyte.usermanagement.persistence.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Phone implements Serializable {
	private static final long serialVersionUID = -8405729317935182661L;
	
	/**
	 * Id del phone
	 */	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;

	/**
	 * numero de telefono
	 */
	private String number;
	
	/**
	 * codigo de ciudad del telefono
	 */
	private Integer cityCode;
	
	/**
	 * codigo de pais del telefono
	 */
	private Integer countryCode;
	
	
	/**
	 * Relacion con la tabla UserM
	 */  
    @ManyToOne
    @JoinColumn(name = "userm_id", nullable = false, updatable = false)
    private UserM userm;
}
