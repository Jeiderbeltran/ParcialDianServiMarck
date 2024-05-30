package org.mycompany.servimark.user;

import java.util.Map;

import org.mycompany.servimark.user.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserExternalAPI {
    ResponseEntity<Map<String, Object>> saveUser(UserDTO userDTO);
}
