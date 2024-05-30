package org.mycompany.servimark.user.repository;

import java.util.List;

import org.mycompany.servimark.service.ServiceDTO;
import org.mycompany.servimark.user.dto.UserDTO;
import org.mycompany.servimark.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepositoty extends JpaRepository<User, String> {

    @Query("""
        SELECT u.id
        FROM User u
        WHERE u.identification = :identification
        """)
    String findByIdentification(@Param("identification") String identification);

    @Query("""
        SELECT u.id
        FROM User u
        WHERE u.email = :email
        """)
    String findByEmail(@Param("email") String email);

    @Query("""
        SELECT u.userStatus.id
        FROM User u
        WHERE u.id = :userId 
    """)
    Long findUserStatusByUserId(@Param("userId") String userId);

}
