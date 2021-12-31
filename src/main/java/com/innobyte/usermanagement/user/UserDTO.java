package com.innobyte.usermanagement.user;

import lombok.Data;
import java.util.List;

@Data
	private String name;
	private String email;
	private String password;
	private List<PhoneDTO> phone;

}