package org.mycompany.servimark.service;

import java.util.Map;

import org.mycompany.servimark.service.dto.CategoryDTO;
import org.mycompany.servimark.user.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface ServiceExternalAPI {
    ResponseEntity<Map<String,Object>> saveService(ServiceDTO serviceDTO);

    ResponseEntity<Map<String,Object>> getHistoryServiceByUser(UserDTO userDTO);

    ResponseEntity<Map<String,Object>> getServicesByCategoryId(CategoryDTO categoryDTO);
}
