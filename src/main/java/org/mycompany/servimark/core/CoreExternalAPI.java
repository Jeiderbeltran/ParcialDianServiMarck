package org.mycompany.servimark.core;

import org.mycompany.servimark.core.dto.DepartamentDTO;
import org.springframework.http.ResponseEntity;

public interface CoreExternalAPI {
    ResponseEntity<?> saveDepartament(DepartamentDTO departamentDTO);
}
