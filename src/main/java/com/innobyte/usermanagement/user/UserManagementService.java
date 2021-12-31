package com.innobyte.usermanagement.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tika.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innobyte.usermanagement.persistence.model.Phone;
import com.innobyte.usermanagement.persistence.model.UserM;
import com.innobyte.usermanagement.persistence.service.PhonePersistenceService;
import com.innobyte.usermanagement.persistence.service.UserMPersistenceService;
import com.innobyte.usermanagement.resources.DataDuplicatedException;
import com.innobyte.usermanagement.resources.DataNotSavedException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserManagementService {

	private static final String RESULT= "result";
	private static final String NAME= "name";
	private static final String EMAIL= "email";
	private static final String PASSWORD= "password";
	private static final String EMAIL_FORMAT="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	
	@Autowired
	private UserMPersistenceService userPSvc;
	
	@Autowired
	private PhonePersistenceService phonePSvc;
	
	public Map<String, Object> basicUserRegistry(UserDTO userDTO) throws DataDuplicatedException, DataNotSavedException {
		Map<String, Object> response = new HashMap<>();
		checkValue(userDTO.getEmail(),EMAIL);
		checkValue(userDTO.getPassword(),PASSWORD);
		userPSvc.existsByEmail(userDTO.getEmail());
		UserM user = new UserM();
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setActive(true);
		user.setToken("");
		userPSvc.save(user);
		for (PhoneDTO phoneDTO : userDTO.getPhone()){
			Phone phone = new Phone();
			phone.setNumber(phoneDTO.getNumber());
			phone.setCityCode(phoneDTO.getCityCode());
			phone.setCountryCode(phoneDTO.getContryCode());
			phone.setUserm(user);
			phonePSvc.save(phone);
        }
		response.put(RESULT, 0);
		response.put("id", user.getId());
		response.put(NAME, user.getName());
		response.put(EMAIL, user.getEmail());
		response.put(PASSWORD, user.getPassword());
		response.put("created",user.getCreatedTimestamp());
		response.put("modified", user.getUpdatedTimestamp());
		response.put("last_login", user.getLastLoginTimestamp());
		response.put("token", "eyJhbGciOiJSU0ExXzUiLCJlbmMiOiJBMTI4Q0JDLUhTMjU2In0.QR1Owv2ug2WyPBnbQrRARTeEk9kDO2w8qDcjiHnSJflSdv1iNqhWXaKH4MqAkQtM" + 
				"oNfABIPJaZm0HaA415sv3aeuBWnD8J-Ui7Ah6cWafs3ZwwFKDFUUsWHSK-IPKxLG" + 
				"TkND09XyjORj_CHAgOPJ-Sd8ONQRnJvWn_hXV1BNMHzUjPyYwEsRhDhzjAD26ima" + 
				"sOTsgruobpYGoQcXUwFDn7moXPRfDE8-NoQX7N7ZYMmpUDkR-Cx9obNGwJQ3nM52" + 
				"YCitxoQVPzjbl7WBuB7AohdBoZOdZ24WlN1lVIeh8v1K4krB8xgKvRU8kgFrEn_a" + 
				"1rZgN5TiysnmzTROF869lQ.AxY8DCtDaGlsbGljb3RoZQ.MKOle7UQrG6nSxTLX6Mqwt0orbHvAKeWnDYvpIAeZ72deHxz3roJDXQyhxx0wKaM" + 
				"HDjUEOKIwrtkHthpqEanSBNYHZgmNOV7sln1Eu9g3J8.fiK51VwhsxJ-siBMR-YFiA");
		response.put("isactive", user.isActive());
		return response;	
	}
	
	private void checkValueRequired(String value) throws DataNotSavedException {
		if (StringUtils.isBlank(value)){
			throw new DataNotSavedException("Email esta vacio");
		}
	}	

	private void checkValue(String value, String name) throws DataNotSavedException {
		checkValueRequired(value);
		log.info(value);
		if (name.equals(EMAIL) && !value.matches(EMAIL_FORMAT)) {
            throw new DataNotSavedException("formato invalido para el email");
        }
		
		if (name.equals(PASSWORD) && !value.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$")) {
            throw new DataNotSavedException("formato invalido para el correo");
        }
	}	
		
	public List<Map<String, Object>> getUsersActive()  {
		return userPSvc.getUsersActive();
    }
}
