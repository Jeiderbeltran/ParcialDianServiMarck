package org.mycompany.servimark.core.repository;

import org.mycompany.servimark.core.models.Departament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentRepository extends JpaRepository<Departament, Short> {
}
