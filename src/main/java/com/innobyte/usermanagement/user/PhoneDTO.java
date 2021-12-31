package com.innobyte.usermanagement.user;

import lombok.Data;

@Data
public class PhoneDTO {
	private String number;
	private Integer cityCode;
	private Integer contryCode;
}
