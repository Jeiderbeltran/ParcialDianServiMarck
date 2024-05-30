package org.mycompany.servimark.core.management;

import jakarta.transaction.Transactional;

import java.util.LinkedHashMap;
import java.util.Map;

import org.mycompany.servimark.core.CoreExternalAPI;
import org.mycompany.servimark.core.CoreInternalAPI;
import org.mycompany.servimark.core.dto.DepartamentDTO;
import org.mycompany.servimark.core.mapper.CoreMapper;
import org.mycompany.servimark.core.models.Departament;
import org.mycompany.servimark.core.repository.DepartamentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CoreManagement implements CoreExternalAPI, CoreInternalAPI {

    private final DepartamentRepository departamentRepository;
    private final CoreMapper coreMapper;

    public CoreManagement(DepartamentRepository departamentRepository, CoreMapper coreMapper) {
        this.departamentRepository = departamentRepository;
        this.coreMapper = coreMapper;
    }

    @Override
    @Transactional
    public ResponseEntity<?> saveDepartament(DepartamentDTO departamentDTO) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        Departament d = coreMapper.departamentDTOToDepartament(departamentDTO);
        map.put("data", coreMapper.departamentToDepartamentDTO(departamentRepository.save(d)));
        map.put("status", "true");
        map.put("message", "Departament saved successfully");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
}
