package org.mycompany.servimark.service.repository;

import org.mycompany.servimark.service.model.UserService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserServiceRepository extends JpaRepository<UserService, String> {
}