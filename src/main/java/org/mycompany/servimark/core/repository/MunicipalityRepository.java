package org.mycompany.servimark.core.repository;

import org.mycompany.servimark.core.models.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MunicipalityRepository extends JpaRepository<Municipality, Long> {
}
